/*#############################################################################
 *###
 *###   Demo for CE related to lab exercise "DAC-Ansteuerung mit ISR"
 *###   ===========
 *#############################################################################
 *
 * VCS: git@bitbucket.org/schaefers/CE-Demo-Curve.git
 *
 * Developed on/for:
 *    TI CE Board (SS15 (resp. SS14))  with
 *      Silica Xynergy-M4 Board  with
 *      STM32F417
 *    using
 *      CEPtemplate (SS15 (resp. 2014/05/08))
 *      Keil µVision V5.11.1.0
 *
 * Code belongs to TI4 CE; Informatik; HAW-Hamburg; Berliner Tor 7; D-20099 Hamburg
 * Code was based on demo examples from Silke Behn, Heiner Heitmann & Bernd Schwarz
 * Code was "mixed up" by Michael Schäfers and was originally designed for Digilent Nexys2 Board
 * Code was adapted/ported to Silica Xynergy Board by Yannic Wilkening
 * Code was "pimped up" by Michael Schäfers (e.g. adding comments and references to documentation)
 *
 *-----------------------------------------------------------------------------
 * Description:
 * ============
 * Code is an example for interaction of interrupts, timer and DAC.
 * Waveform with 7.5ms period (~133.3Hz) has to be send out over DAC.
 * Frequency of the (individual waveform) samples shall be 48KHz.
 *
 * The task/main loop has to compute signals and to store them in a fifo buffer.
 *     As metapher for the signal computation the task has to read out an appropriate sample ...
 *     of a signal table containing 1013 waveform samples (taken in equidistant time steps).
 * Timer8 has to signal via IRQ that it is time to send the next sample to DAC (with 48KHz frequency ;-)
 * The (this way) triggered ISR has to hand over the sample (from fifo) to DAC.
 *
 * LED7 on the CEP board is connected to GPIO I.7 of µC and used to mark that NO fifo underflow has occured
 * LED6 on the CEP board is connected to GPIO I.6 of µC and used to mark an Error resulting out of a fifo underflow
 * LED5 on the CEP board is connected to GPIO I.5 of µC and used to mark a spurious interrupt
 *
 * S8 toggle timer (either start or stop)
 * S7 acknowledges error detection by clearing LED6&5 and setting LED7
 * S6 clear LED7&6&5 (to controll that they are working)
 * S5 set LED7&6&5 (to controll that they are working)
 * S4 trap computation by busy waiting that S4 is released  producing fifo underflow this way
 *
 *-----------------------------------------------------------------------------
 * Abbreviations:
 * ==============
 *
 * DS ::= (STM32F415xx,) STM32F417xx Data Sheet ;   DM00035129 ;  DocID_022063 Rev5 ;  2015-03
 * PM ::= Programming Manual PM0214 ;               DM00046982 ;  DocID 022708 Rev4 ;  2014-04
 * RM ::= Reference Manual   RM0090 ;               DM00031020 ;  DocID 018909 Rev9 ;  2015-03
 * ~~~~~~
 * Guide ::= The Definitive Guide to ARM Cortex-M3 and Cortex-M4 Processors ;  Yiu,Joseph ;  3ed
 *
 *-----------------------------------------------------------------------------
 * History:
 * ========
 *   150423-150426: code ported to Silica Xynergy Board by Yannic Wilkening & Florian Meyer (see git@BitBucket.org/blamaster/demo-code-ce-a4.git)
 *   150427-150520: adding comments, references to documentation and negletable code changes by Michael Schäfers
 *   For "full history" see ReadMe.txt (git@BitBucket.org/schaefers/CE-Demo-Curve.git)
 *-----------------------------------------------------------------------------
 * KNOWN PROBLEMS: none
 * NOTEs:          none
 *                 respectively:
 *                      Wann englisch und wann deutsch?
 *                      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *                      Grundsaetzlich gilt, wer C-Code fuer einen STM32 liest, der sollte auch C und STM32 kennen.
 *                      Dies ist aber ein Demo-Code, der auch "Dinge" erklaeren soll.
 *                      Kommentar/Erklaerungen der/die deswegen hier sind, werden in deutsch geschrieben
 *                      Kommentar, den auch ein "normales Programm" aufweisen sollte, hingegen in englisch.
 *                      {>...} markiert Referenzen auf Dokumentation oder eingebundene Dateien
 * OPEN POINTS:    Should all be removed in the final version, anyway they have been marked with: _???_<YYMMDD>  (search/grep for _???_)
 */



// current code version - increment with each change
#define  THE_VERY_C_CODE_VERSION  "v2.007"





/*
 * Header-Dateien, die benoetigt werden
 */
#include <stdint.h>
#include <stm32f4xx.h>
#include <stm32f4xx_rcc.h>
#include <stm32f4xx_gpio.h>
#include "CE_Lib.h"
#include "tft.h"





// comment line if you do NOT want additional test support functionality
#define TEST_SUPPORT_ENABLE

// comment line if you do NOT want to use TFT display
#define TFT_ENABLE

// comment line if you do NOT want to implement a final catch for safety's sake
//#define FINAL_CATCH_FOR_SAFETYS_SAKE_ENABLE





/*
 * macro converts binary value (containing up to 8 bits resp. <=0xFF) to unsigned decimal value
 * macro does NOT check for an invalid argument at all
 *
 * Das Macro ist Ersatz fuer fehlendes 0b-Prefix,  wie es ab GCC4.3 unterstuetzt und seit C++14 eingefordert wird.
 * Dieses Macro unterstuetzt NUR Werte bis zu 8Bit.
 * Sinn des Macros ist es Bitfelder in ihrer Groesse kenntlich zu machen. Also z.B. b(00111) fuer den 5Bit-Wert: dezimal 7.
 *
 * Die Syntax fuer dieses Macro ist nicht einfach. Sie muessen die Syntax NICHT verstehen. Sie muessen das Macro NUR anwenden koennen.
 * Wie auch immer:
 *   "##" ist ein "token-pasting"-Operator oder auch "zusammenfuehrender"-Operator.
 *   Beispielsweise nach einem Aufruf "b(010)" hat der Macro-Parameter "n" den Wert "010"
 *   und in diesem Fall wird"0x##b##ul" zu "0x010ul".
 *   Hierbei steht "0x" wie gewohnt fuer Hex und "ul" fuer "unsigned long".
 * Noch einmal, Sie muessen dieses Macro NUR anwenden koennen.
 */
#define b(n) (                                               \
    (unsigned char)(                                         \
            ( ( (0x##n##ul) & 0x00000001 )  ?  0x01  :  0 )  \
        |   ( ( (0x##n##ul) & 0x00000010 )  ?  0x02  :  0 )  \
        |   ( ( (0x##n##ul) & 0x00000100 )  ?  0x04  :  0 )  \
        |   ( ( (0x##n##ul) & 0x00001000 )  ?  0x08  :  0 )  \
        |   ( ( (0x##n##ul) & 0x00010000 )  ?  0x10  :  0 )  \
        |   ( ( (0x##n##ul) & 0x00100000 )  ?  0x20  :  0 )  \
        |   ( ( (0x##n##ul) & 0x01000000 )  ?  0x40  :  0 )  \
        |   ( ( (0x##n##ul) & 0x10000000 )  ?  0x80  :  0 )  \
    )                                                        \
)



/*
 * simplified access to switches S0 - S7
 */
#define  S8   ( !(GPIOH->IDR & (b(1) << 15)) )
#define  S7   ( !(GPIOH->IDR & (b(1) << 12)) )
#define  S6   ( !(GPIOH->IDR & (b(1) << 10)) )
#define  S5   ( !(GPIOF->IDR & (b(1) << 8 )) )
#define  S4   ( !(GPIOF->IDR & (b(1) << 7 )) )
#define  S3   ( !(GPIOF->IDR & (b(1) << 6 )) )
#define  S2   ( !(GPIOC->IDR & (b(1) << 2 )) )
#define  S1   ( !(GPIOI->IDR & (b(1) << 9 )) )





/*
 * Achtung:
 * Die in "misc.h" definierten Token "NVIC_PriorityGroup_#" sind NICHT geeignet
 * fuer die in "core_cm3.h" definierte Funktion "NVIC_SetPriorityGrouping()".
 * "NVIC_SetPriorityGrouping()" erwartet nur das BitFeld selbst.
 * Die Token definieren jedoch das BitFeld bereits an der "richtigen Position" (also einschliesslich niederwertigerer Bits).
 *
 * Das Prefix "STM32" markiert die nachfolgend selbstdefinierten Token, die nur das BitFeld selbst definieren
 * und damit fuer "NVIC_SetPriorityGrouping()" geeignet sind.
 *
 * Cortex-M3&M4 (STM32) erwarten den PriorityGrouping-Wert im Bereich 0,..,7
 * "pre-emption priority" ist ein veralteter Name fuer "group priority".
 * 
 * Fuer weitere Informationen siehe:
 *  {> Guide: chap7.4 }
 *  {> misc.h }
 *  {> core_cm3.h und dort NVIC_SetPriorityGrouping() }
 */
#define  STM32_NVIC_PriorityGroup_0   ((uint32_t)0x7)           /*!< 0 bits for pre-emption priority 4 bits for subpriority */
#define  STM32_NVIC_PriorityGroup_1   ((uint32_t)0x6)           /*!< 1 bits for pre-emption priority 3 bits for subpriority */
#define  STM32_NVIC_PriorityGroup_2   ((uint32_t)0x5)           /*!< 2 bits for pre-emption priority 2 bits for subpriority */
#define  STM32_NVIC_PriorityGroup_3   ((uint32_t)0x4)           /*!< 3 bits for pre-emption priority 1 bits for subpriority */
#define  STM32_NVIC_PriorityGroup_4   ((uint32_t)0x3)           /*!< 4 bits for pre-emption priority 0 bits for subpriority */



/*
 * timer setup
 * ============
 */
#define  SYS_FREQ     168000000                                     // 168MHz system frequency
#define  TIMER_FREQ       48000                                     // 48KHz requested timer frequency





/*
 * FIFO for data handover from "task" to ISR
 * ====
 */
//
// FIFO_BUFF_SIZE has to equal 2^n                                     (for FIFO_INDX_MSK)
#define   FIFO_BUFF_SIZE   ( b(1) << 2 )                            /*!< 4 entries fifo depth resp. buffer size */
//const int FIFO_BUFF_SIZE = 0x4;                                   // ab GCC 4.3 ist "const" i.d.R. dem "#define" vorzuziehen
//
// FIFO INDeX MaSK ;      "& ((2^n)-1)"  <=> "% ((2^n)-1)              FIFO-INDeX-MaSK WONT work if FIFO-BUFF-SIZE does NOT equal 2^n !!!
#define   FIFO_INDX_MSK   ( FIFO_BUFF_SIZE - 1 )
//const int FIFO_INDX_MSK = FIFO_BUFF_SIZE - 1;                     // ab GCC 4.3 ist "const" i.d.R. dem "#define" vorzuziehen
//
static volatile uint16_t fifo[ FIFO_BUFF_SIZE ] = { 0 };            // FIFO BUFFER
static volatile uint16_t fifoRdIndx = 0;                            // FIFO ReaD  INDeX
static volatile uint16_t fifoWrIndx = 0;                            // FIFO WRite INDeX



/*
 * MARKER
 * ======
 *
 * In der ISR sollte so kurz wie moeglich sein. Zugriff auf externe Peripherie kostet Zeit.
 * In der ISR werden (u.U.) Marker gesetzt.
 * Der Main-Loop wertet die Marker aus und reagiert entsprechend.
 * In der Konsequenz ist die ISR kurz und fuer den Main-Loop kann bewusst geplant werden, wann die Zeit fuer die noetigen Dinge aufgebracht wird.
 * Dies kann das Einhalten von Echtzeitanforderungen erleichtern.
 */
static volatile int8_t   fifoUnderflow = 0;                         // "FIFO buffer UNDERFLOW was detected" state
static volatile int8_t   spuriousInterrupt = 0;                     // "spurious interrupt was detected" state





/*
 * SIGNAL TABLE containing samples of signal
 * ============
 *
 * signal values inside SIGNAL TABLE are guaranteed to be in 10 bit range [+0, .., +1023]
 *
 * Die Signal-Tabelle hat bewusst die "kranke Anzahl" von 1013 Eintraegen um den Uebungswert zu erhoehen.
 * In einer realen Anwendung ist so etwas natuerlich zu vermeiden.
 */
// 
// SIGnal TABle Number Of Entries
#define   SIG_TAB_NOE   ( 1013 )
//
// SIGNAL TABLE
static uint16_t signalTable[SIG_TAB_NOE] = {
     512,  519,  525,  532,  539,  546,  552,  559,  566,  572,  579,  586,  592,  599,  606,  612,  619,  625,  632,  638,  645,  651,  658,  664, 
     671,  677,  683,  689,  696,  702,  708,  714,  720,  726,  732,  738,  744,  750,  756,  762,  768,  773,  779,  785,  790,  796,  801,  807, 
     812,  817,  822,  828,  833,  838,  843,  848,  853,  858,  862,  867,  872,  876,  881,  885,  890,  894,  898,  902,  906,  911,  914,  918, 
     922,  926,  930,  933,  937,  940,  944,  947,  950,  954,  957,  960,  963,  966,  969,  971,  974,  977,  979,  982,  984,  986,  989,  991, 
     993,  995,  997,  999, 1000, 1002, 1004, 1006, 1007, 1008, 1010, 1011, 1012, 1014, 1015, 1016, 1017, 1018, 1018, 1019, 1020, 1021, 1021, 1022, 
    1022, 1022, 1023, 1023, 1023, 1023, 1023, 1023, 1023, 1023, 1023, 1023, 1023, 1022, 1022, 1021, 1021, 1020, 1020, 1019, 1018, 1018, 1017, 1016, 
    1015, 1014, 1013, 1012, 1011, 1010, 1009, 1008, 1007, 1005, 1004, 1003, 1001, 1000,  999,  997,  996,  994,  993,  991,  990,  988,  986,  985, 
     983,  981,  980,  978,  976,  975,  973,  971,  969,  967,  966,  964,  962,  960,  958,  957,  955,  953,  951,  949,  947,  946,  944,  942, 
     940,  938,  937,  935,  933,  931,  929,  928,  926,  924,  923,  921,  919,  918,  916,  914,  913,  911,  910,  908,  907,  905,  904,  902, 
     901,  900,  898,  897,  896,  894,  893,  892,  891,  890,  889,  888,  887,  886,  885,  884,  883,  882,  881,  880,  880,  879,  878,  878, 
     877,  877,  876,  876,  875,  875,  875,  874,  874,  874,  874,  874,  874,  874,  874,  874,  874,  874,  874,  874,  875,  875,  875,  876, 
     876,  876,  877,  878,  878,  879,  879,  880,  881,  882,  882,  883,  884,  885,  886,  887,  888,  889,  890,  891,  893,  894,  895,  896, 
     898,  899,  900,  902,  903,  904,  906,  907,  909,  910,  912,  914,  915,  917,  918,  920,  922,  923,  925,  927,  929,  930,  932,  934, 
     936,  937,  939,  941,  943,  945,  947,  948,  950,  952,  954,  956,  958,  959,  961,  963,  965,  967,  968,  970,  972,  974,  975,  977, 
     979,  981,  982,  984,  986,  987,  989,  990,  992,  993,  995,  996,  998,  999, 1001, 1002, 1003, 1005, 1006, 1007, 1008, 1010, 1011, 1012, 
    1013, 1014, 1015, 1016, 1016, 1017, 1018, 1019, 1019, 1020, 1021, 1021, 1022, 1022, 1022, 1023, 1023, 1023, 1023, 1023, 1023, 1023, 1023, 1023, 
    1023, 1023, 1022, 1022, 1021, 1021, 1020, 1020, 1019, 1018, 1017, 1016, 1015, 1014, 1013, 1012, 1011, 1009, 1008, 1006, 1005, 1003, 1001, 1000, 
     998,  996,  994,  992,  990,  987,  985,  983,  980,  978,  975,  973,  970,  967,  964,  961,  958,  955,  952,  949,  945,  942,  939,  935, 
     932,  928,  924,  920,  916,  913,  908,  904,  900,  896,  892,  887,  883,  879,  874,  869,  865,  860,  855,  850,  845,  840,  835,  830, 
     825,  820,  815,  809,  804,  798,  793,  787,  782,  776,  771,  765,  759,  753,  747,  741,  735,  729,  723,  717,  711,  705,  699,  693, 
     686,  680,  674,  667,  661,  655,  648,  642,  635,  629,  622,  615,  609,  602,  596,  589,  582,  576,  569,  562,  556,  549,  542,  536, 
     529,  522,  515,  509,  502,  495,  488,  482,  475,  468,  462,  455,  448,  442,  435,  428,  422,  415,  409,  402,  395,  389,  382,  376, 
     369,  363,  357,  350,  344,  338,  331,  325,  319,  313,  307,  301,  295,  289,  283,  277,  271,  265,  259,  253,  248,  242,  237,  231, 
     226,  220,  215,  209,  204,  199,  194,  189,  184,  179,  174,  169,  164,  159,  155,  150,  145,  141,  137,  132,  128,  124,  120,  116, 
     111,  108,  104,  100,   96,   92,   89,   85,   82,   79,   75,   72,   69,   66,   63,   60,   57,   54,   51,   49,   46,   44,   41,   39, 
      37,   34,   32,   30,   28,   26,   24,   23,   21,   19,   18,   16,   15,   13,   12,   11,   10,    9,    8,    7,    6,    5,    4,    4, 
       3,    3,    2,    2,    1,    1,    1,    1,    1,    1,    1,    1,    1,    1,    1,    2,    2,    2,    3,    3,    4,    5,    5,    6, 
       7,    8,    8,    9,   10,   11,   12,   13,   14,   16,   17,   18,   19,   21,   22,   23,   25,   26,   28,   29,   31,   32,   34,   35, 
      37,   38,   40,   42,   43,   45,   47,   49,   50,   52,   54,   56,   57,   59,   61,   63,   65,   66,   68,   70,   72,   74,   76,   77, 
      79,   81,   83,   85,   87,   88,   90,   92,   94,   95,   97,   99,  101,  102,  104,  106,  107,  109,  110,  112,  114,  115,  117,  118, 
     120,  121,  122,  124,  125,  126,  128,  129,  130,  131,  133,  134,  135,  136,  137,  138,  139,  140,  141,  142,  142,  143,  144,  145, 
     145,  146,  146,  147,  148,  148,  148,  149,  149,  149,  150,  150,  150,  150,  150,  150,  150,  150,  150,  150,  150,  150,  150,  149, 
     149,  149,  148,  148,  147,  147,  146,  146,  145,  144,  144,  143,  142,  141,  140,  139,  138,  137,  136,  135,  134,  133,  132,  131, 
     130,  128,  127,  126,  124,  123,  122,  120,  119,  117,  116,  114,  113,  111,  110,  108,  106,  105,  103,  101,  100,   98,   96,   95, 
      93,   91,   89,   87,   86,   84,   82,   80,   78,   77,   75,   73,   71,   69,   67,   66,   64,   62,   60,   58,   57,   55,   53,   51, 
      49,   48,   46,   44,   43,   41,   39,   38,   36,   34,   33,   31,   30,   28,   27,   25,   24,   23,   21,   20,   19,   17,   16,   15, 
      14,   13,   12,   11,   10,    9,    8,    7,    6,    6,    5,    4,    4,    3,    3,    2,    2,    1,    1,    1,    1,    1,    1,    1, 
       1,    1,    1,    1,    2,    2,    2,    3,    3,    4,    5,    6,    6,    7,    8,    9,   10,   12,   13,   14,   16,   17,   18,   20, 
      22,   24,   25,   27,   29,   31,   33,   35,   38,   40,   42,   45,   47,   50,   53,   55,   58,   61,   64,   67,   70,   74,   77,   80, 
      84,   87,   91,   94,   98,  102,  106,  110,  113,  118,  122,  126,  130,  134,  139,  143,  148,  152,  157,  162,  166,  171,  176,  181, 
     186,  191,  196,  202,  207,  212,  217,  223,  228,  234,  239,  245,  251,  256,  262,  268,  274,  280,  286,  292,  298,  304,  310,  316, 
     322,  328,  335,  341,  347,  353,  360,  366,  373,  379,  386,  392,  399,  405,  412,  418,  425,  432,  438,  445,  452,  458,  465,  472, 
     478,  485,  492,  499,  505
};//signalTable





//----------------------------------------------------------------------------
//
//  ISR
//

/*
 * ISR: "TIM8_UP_TIM13_IRQHandler"
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *
 * "startup_stm32f2xx.s" definiert
 *   die Funktion/ISR
 *      TIM8_UP_TIM13_IRQHandler                                                siehe Abschnitt: "Vector Table Mapped to Address 0 at Reset"
 * Die "Definition" erfolgt durch den jeweiligen Eintrag in der IVT.
 * Hier werden WEAK-References eingetragen, die dann durch die eigene ISR-Deklaration ueberschrieben werden.
 * Als Konsequenz dieser Technik sind Spurious Interrupts sehr unwahrscheinlich.
 * Ein Test auf einen Spurious Interrupt ist daher "hier" eigentlich unnoetig.
 * Da es in Zusammenhang mit anderen andersartigen Systemen aber guter Stil ist, wird dieser Test hier trotzdem durchgefuehrt.
 *
 * "stm32f4xx.h" definiert
 *   den Pointer
 *      DAC   auf den Memory-Mapped Digital-Analog-Converter                    siehe Abschnitt: "Peripheral_declaration"
 *      TIM8  auf den Memory-Mapped Timer#8                                     siehe Abschnitt: "Peripheral_declaration"
 *   die zugehoerigen Register
 *      DHR12R1 ::= DAC channel#1 12-bit right-aligned data holding register    siehe struct-Definiton: "DAC_TypeDef"
 *      SR      ::= Status Register                                             siehe struct-Definiton: "TIM_TypeDef"
 *   die zugehoerigen Bit-Definitionen
 *      TIM_SR_UIF ::= Update Interrupt Flag                                    siehe Abschnitt: "TIM / Bit definition for TIM_CR1 register"
 *
 *
 * Gesetzte Flags/Bits im SR werden geloescht indem diese Flags/Bits mit 0 beschrieben werden.
 * Das Beschreiben eines Bits im SR mit 1 hat keine Wirkung - es laesst das jeweilige Bit unveraendert.
 *
 * Fuer weitere Informationen siehe:
 *  {> RM0090: chap17 }  Hier wird der Timer#8 behandelt.
 */
void TIM8_UP_TIM13_IRQHandler(void){                                // ISR for Timer8 IRQs
    //
#ifdef TEST_SUPPORT_ENABLE
    if( TIM8->SR & TIM_SR_UIF ){                                    // is service actually requested?
        // yes, there is an actual request for this service
#endif
        
        // clear flag marking the IRQ
        // ==========
        //
        TIM8->SR = ~TIM_SR_UIF;                                     // acknowledge interrupt resp. clear IRQ-flag to receive new interrupts   {>RM0090 chap 17.4.5}  _???_<150508> reference that writing clears bit
        
        
        // handle IRQ  resp. do requested service
        // ==========
        //
        // load new signal value from fifo buffer, align it and hand it over to DAC
        if ( fifoRdIndx != fifoWrIndx ){                            // check for fifo underflow
            // NO fifo underflow => required data is in fifo
            //
            // send data to DAC
            DAC->DHR12R1 = fifo[fifoRdIndx];                        // load current data value into DAC output register {>RM0090 chap 14.5.3}
            //
            // update FIFO ReaD INDeX
            fifoRdIndx = (fifoRdIndx + 1) & FIFO_INDX_MSK;          // cyclic increment
            
        }else{
            // fifo is empty
            //
            fifoUnderflow = -1;                                     // mark FIFO UNDERFLOW
            //
        }//if
            
            
#ifdef TEST_SUPPORT_ENABLE
    }else{
        // service was NOT requested                                   if we end up here, who is doing acknowledge and where ??? => LOOP(!?)
        //
        spuriousInterrupt = -1;                                     // mark SPURIOUS INTERRUPT
    }//if
#endif
    //
}//TIM8_UP_TIM13_IRQHandler()





//----------------------------------------------------------------------------
//
// function prototype(s)
//
void showInfoOnTFT(void);





//----------------------------------------------------------------------------
//
//  MAIN
//
int main( void ){

    // fifo specific
    uint16_t fifoNextWrIndx  =  0;                                  // FIFO NEXT WRite INDeX
    
    // signal table specific
    const int16_t NOS        =  360;                                // Number Of Samples  ; 48KHz/133.3Hz = 48000Hz/((4/3)*100Hz) = 480*3/4 = 360  ; "Q15.0"
    const int32_t LIMIT      =  SIG_TAB_NOE<<20;                    // shift left for increased precision         ; 2^20 * 1013       = 1062207488 ;  Q11.20
    const int32_t DELTA      =  LIMIT/NOS;                          // delta for index (with increased precision) ; 2^20 * 1013/360   =    2950576 ;  Q11.20
    const int32_t MAX_INDX   =  LIMIT-(2*DELTA)+1;                  // (min. value of) MAXimum INDeX (with increased precision)                    ;  Q11.20
    //
    int32_t sigTabIndx       =  0;                                  // SIGnal TABle INDeX ; initialize with start position                         ;  Q11.20
    
    //
    uint8_t pinPos;                                                 // PIN POSition (when configuring GPIO)
    
    
    /*
     * general setup
     * =============
     */
    initCEP_Board();                                                // initilize display, leds, buttons, uart and other stuff CE_Lib.c
#ifdef TFT_ENABLE
    showInfoOnTFT();
#endif
    
    
    
    /* clock setup
     * ===========
     *
     * switch on needed components
     *
     * Fuer alle benoetigten Komponenten wie Ports, Timer und DAC wird der CLK angeschaltet.
     * Hierfuer muss auf das RCC (Reset and Clock Control) Register konfiguriert werden.
     * AHB ::= Advanced High-performance Bus    (protocol as part of AMBA specification)
     * APB ::= Advanced Peripheral Bus          (protocol as part of AMBA specification)
     * AMBA ::= Advanced Microcontroller Bus Architecture
     *
     * "stm32f4xx.h" definiert
     *   den Pointer
     *      RCC   auf den Memory-Mapped Reset and Clock Control block               siehe Abschnitt: "Peripheral_declaration"
     *   die zugehoerigen Register
     *      AHB1ENR ::= AHB1 peripheral clock ENable Register                       siehe struct-Definiton: "RCC_TypeDef"
     *      AHB2ENR ::= AHB2 peripheral clock ENable Register                       siehe struct-Definiton: "RCC_TypeDef"
     *   die zugehoerigen Bit-Definitionen
     *      RCC_AHB1ENR_DACEN                                                       siehe Abschnitt: "Bit definition for RCC_AHB1ENR register"
     *      RCC_AHB1ENR_GPIO*EN                                                     siehe Abschnitt: "Bit definition for RCC_AHB1ENR register"
     *      RCC_AHB2ENR_TIM*EN                                                      siehe Abschnitt: "Bit definition for RCC_AHB2ENR register"
     */
    RCC->AHB1ENR |= (   RCC_AHB1ENR_GPIOAEN                         // enable clock for GPIOA                           {>RM0090 chap 6.3.10}
                      | RCC_AHB1ENR_GPIOCEN                         // enable clock for GPIOC                           {>s.a.}
                      | RCC_AHB1ENR_GPIOFEN                         // enable clock for GPIOF                           {>s.a.}
                      | RCC_AHB1ENR_GPIOHEN                         // enable clock for GPIOH                           {>s.a.}
                      | RCC_AHB1ENR_GPIOIEN                         // enable clock for GPIOI                           {>s.a.}
    );
    //
    RCC->APB1ENR |= RCC_APB1ENR_DACEN;                              // enable clock for DAC                             {>RM0090 chap 6.3.13}
    //
    RCC->APB2ENR |= RCC_APB2ENR_TIM8EN;                             // enable clock for timer 8                         {>RM0090 chap 6.3.14}
    
    
    
    /*
     * LED setup (actually already initialised/done by initCEP_Board()
     * =========
     *
     * LED7 ::= OK - NO fifo underflow since start                  ( connected to GPIO I.7 )
     * LED6 ::= ERROR - at least one fifo undeflow since start      ( connected to GPIO I.6 )
     * LED5 ::= false interrupt                                     ( connected to GPIO I.5 )
     *
     * "stm32f4xx.h" definiert
     *   den Pointer
     *      GPIOI   auf den Memory-Mapped "GPIO-I Block"              siehe Abschnitt: "Peripheral_declaration"
     *   die zugehoerigen Register
     *      MODER   ::= gpio port MODE Register                       siehe struct-Definiton: "GPIO_TypeDef"
     *      OSPEEDR ::= gpio port Output SPEED Register               siehe struct-Definiton: "GPIO_TypeDef"
     *      OTYPER  ::= gpio port Output TYPE Register                siehe struct-Definiton: "GPIO_TypeDef"
     *      PUPDR   ::= gpio port Pull-Up/Pull-Down Register          siehe struct-Definiton: "GPIO_TypeDef"
     * "stm32f4xx_gpio.h" definiert
     *   die zugehoerigen Bit-Definitionen
     *      GPIO_Low_Speed (frueher/veraltet: GPIO_Speed_2MHz)        siehe enum-Definiton: "GPIOSpeed_TypeDef" (GPIO Output Maximum frequency enumeration)
     *      GPIO_Mode_OUT                                             siehe enum-Definiton: "GPIOMode_TypeDef"  (GPIO Configuration Mode enumeration)
     *      GPIO_OType_PP                                             siehe enum-Definiton: "GPIOOType_TypeDef" (GPIO Output type enumeration)
     *      GPIO_PuPd_NOPULL                                          siehe enum-Definiton: "GPIOPuPd_TypeDef"  (GPIO Configuration PullUp PullDown enumeration)
     *
     * Fuer weitere Informationen siehe:
     *  {> TI2 GS }
     *  {> RM0090 chap 8.3&4 }
     */
    for( pinPos=4; pinPos<=7; pinPos++ ){
        GPIOI->OTYPER  = (GPIOI->OTYPER  & ~( b(11) << (pinPos*2))) | (GPIO_OType_PP    << (pinPos*2));             //  {>RM0090 chap 8.4.2}
        GPIOI->OSPEEDR = (GPIOI->OSPEEDR & ~( b(11) << (pinPos*2))) | (GPIO_Low_Speed   << (pinPos*2));             //  {>RM0090 chap 8.4.3}
        GPIOI->PUPDR   = (GPIOI->PUPDR   & ~( b(11) << (pinPos*2))) | (GPIO_PuPd_NOPULL << (pinPos*2));             //  {>RM0090 chap 8.4.4}
        GPIOI->MODER   = (GPIOI->MODER   & ~( b(11) << (pinPos*2))) | (GPIO_Mode_OUT    << (pinPos*2));             //  {>RM0090 chap 8.4.1}
    }//for
    
    
    
    /*
     * Timer setup
     * ===========
     *
     * "stm32f4xx.h" definiert
     *   den Pointer
     *      TIM8  auf den MemoryMapped Timer8                       siehe Abschnitt: "Peripheral_declaration"
     *   die zugehoerigen Register
     *      ARR  ::= AutoReloadRegister                             siehe struct-Definiton: "TIM_TypeDef"
     *      CR1  ::= ControlRegister1                               siehe struct-Definiton: "TIM_TypeDef"
     *      CR2  ::= ControlRegister2                               siehe struct-Definiton: "TIM_TypeDef"
     *      DIER ::= Dma/InterruptEnableRegister                    siehe struct-Definiton: "TIM_TypeDef"
     *      PSC  ::= PreSCaler                                      siehe struct-Definiton: "TIM_TypeDef"
     *   die zugehoerigen Bit-Definitionen
     *      TIM_CR1_ARPE ::= Auto-Reload Preload Enable             siehe Abschnitt: "TIM / Bit definition for TIM_CR1 register"
     *      TIM_DIER_UIE ::= Update Interrupt Enable                siehe Abschnitt: "TIM / Bit definition for TIM_DIER register"
     *
     * Fuer weitere Informationen siehe:
     *  {> TI2 GS }
     *  {> RM0090 chap 17 }
     */
    TIM8->CR1 = 0;                                                  // disabled timer                   {>RM0090 chap 17.4.1)  
    TIM8->CR2 = 0;                                                  //                                  {>RM0090 chap 17.4.2}
    TIM8->PSC = 0;                                                  // NO prescaler                     {>RM0090 chap 17.4.11}
    TIM8->ARR = (SYS_FREQ / TIMER_FREQ) -1;                         // 48000Hz                          {>RM0090 chap 17.4.12}
    TIM8->DIER = TIM_DIER_UIE;                                      // enable interrupt                 {>RM0090 chap 17.4.4}
    TIM8->CR1 = TIM_CR1_ARPE;                                       // auto-reload preload enable       {>RM0090 chap 17.4.1}
    
    
    
    /*
     * NVIC ((Nested Vector) Interrupt Controller) specific settings                                    {>PM0214 chap 2.3 & 4.3.10 & 4.4.5}
     * ====
     *
     * Achtung kleiner Prioritaetswerte haben hoehere Dringlichkeit/Prioritaet
     *
     * Hier muessen
     *   das Priority Grouping eingestellt werden.
     *     Also im Falle des STM32F417, wieviele der 4Bit jeweils die Pre-Emption Priority und wieviele die Sub-Priority bestimmen
     *   die konkrete Priority bzw. die onkreten Werte fuer Pre-Emption Priority und Sub-Priority
     *   die Interrupts freigeschaltet werden
     *
     * Das Prozessor-spezifische Header-File "core_cm3.h" (als Teilstueck des CMSIS-Core) definiert
     *   die Funktionen
     *      NVIC_EnableIRQ()                                        siehe Abschnitt: "NVIC functions"
     *      NVIC_SetPriority()                                      siehe Abschnitt: "NVIC functions"
     *      NVIC_SetPriorityGrouping()                              siehe Abschnitt: "NVIC functions"
     * "stm32f4xx.h" definiert
     *   die zugehoerigen Bit-Definitionen
     *      TIM8_UP_TIM13_IRQn                                      siehe enum-Definiton: "IRQn_Type"  (STM32F4XX Interrupt Number Definition(, according to the selected device))
     * Das zuvor selbstdefinierte Token
     *      STM32_NVIC_PriorityGroup_2                              ist "angelehnt" an NVIC_PriorityGroup_2 aus misc.h
     *
     * Fuer weitere Informationen siehe:
     *  {> Guide: chap7.3&4 }
     */
    NVIC_SetPriorityGrouping( STM32_NVIC_PriorityGroup_2 );         // 2bit preEmptionPrio & 2bit subPrio
    NVIC_SetPriority( TIM8_UP_TIM13_IRQn, 4 );                      // preEmptionPrio:=1 & subPrio:=0
    NVIC_EnableIRQ( TIM8_UP_TIM13_IRQn );                           // enable IRQ
    
    
    
    /*
     * Digital Analog Converter (DAC)                                                                                   {>RM0090 chap 14}
     * ==============================
     *
     * Set GPIOA.4 to ANalog for use with DAC                                                                           {>RM0090 chap 8.3.2, Peripheral alternate function   & stm32f4xx.h}
     *
     * "stm32f4xx.h" definiert
     *   den Pointer
     *      GPIOA   auf den Memory-Mapped "GPIO-A Block"              siehe Abschnitt: "Peripheral_declaration"
     *   die zugehoerigen Register
     *      MODER   ::= gpio port MODE Register                       siehe struct-Definiton: "GPIO_TypeDef"
     * "stm32f4xx_gpio.h" definiert
     *   die zugehoerigen Bit-Definitionen
     *      GPIO_PinSource4 ::= PIN #4 is SOURCE (hier => GPIO A4)    siehe Abschnitt: "GPIO_Pin_sources"
     *      GPIO_Mode_AN    ::= Analog Mode                           siehe enum-Definiton: "GPIOMode_TypeDef"  (GPIO Configuration Mode enumeration)
     *
     * "stm32f4xx.h" definiert
     *   den Pointer
     *      DAC   auf den Memory-Mapped "Digital Aanalog Converter block"   siehe Abschnitt: "Peripheral_declaration"
     *   die zugehoerigen Register
     *      CR ::= Control Register                                   siehe struct-Definiton: "DAC_TypeDef"
     *   die zugehoerigen Bit-Definitionen
     *      GPIO_PinSource4 ::= PIN #4 is SOURCE (hier => GPIO A4)    siehe Abschnitt: "Digital to Analog Converter / Bit definition for DAC_CR register"
     *
     * Fuer weitere Informationen siehe:
     *  {> TI2 GS }
     *  {> RM0090 chap 8 }
     *  {> RM0090 chap 14 }
     */
    GPIOA->MODER = (GPIOA->MODER & ~(b(11) << (GPIO_PinSource4 * 2))) | (GPIO_Mode_AN << (GPIO_PinSource4 * 2));
    DAC->CR = 0;                                                    // ControlRegister: configure / keep defaults       {>RM0090 chap 14.5.1}
    DAC->CR |= DAC_CR_EN1;                                          // ControlRegister: Enable DAC channel1             {>RM0090 chap 14.5.1}
    
    
    
    // fill fifo
    sigTabIndx = 0;
    do{
        // write into fifo
        fifoWrIndx = fifoNextWrIndx;                                // update FIFO Write INDeX
        fifo[ fifoWrIndx ] = signalTable[ sigTabIndx >> 20 ];       // write value into fifo
        
        // update SIGNAL TABle INDeX
        if( sigTabIndx < MAX_INDX ){                                // already at end of table?
            sigTabIndx += DELTA;                                    //   NO -> increment
        }else{                                                      //
            sigTabIndx = 0;                                         //   YES -> start again at beginning
        }//if                                                       //
        
        // compute next FIFO WRite INDeX
        fifoNextWrIndx = (fifoWrIndx + 1) & FIFO_INDX_MSK;          // cyclic increment
        
    }while( fifoNextWrIndx != fifoRdIndx );                         // stop when buffer filled
    
    
    
    /*
     * "stm32f4xx.h" definiert
     *   den Pointer
     *      GPIOI   auf den Memory-Mapped "GPIO-I Block"              siehe Abschnitt: "Peripheral_declaration"
     *   die zugehoerigen Register
     *      BSRRL ::= gpio port Bit Set[/Reset] Register [Low]        siehe struct-Definiton: "GPIO_TypeDef"
     *      BSRRH ::= gpio port Bit [Set/]Reset Register [High]       siehe struct-Definiton: "GPIO_TypeDef"
     *
     * Fuer weitere Informationen siehe:
     *  {> TI2 GS }
     */
    // initialize LED(s)
    GPIOI->BSRRL =  b(1) << 7;                                      // set OK - NO fifo underflow yet
    GPIOI->BSRRH = b(11) << 5;                                      // NO fifo underflow yet  and  NO spurious interrupt yet
    
    
    
    /*
     * "stm32f4xx.h" definiert
     *   den Pointer
     *      TIM8  auf den MemoryMapped Timer8                       siehe Abschnitt: "Peripheral_declaration"
     *   die zugehoerigen Register
     *      CR1  ::= ControlRegister1                               siehe struct-Definiton: "TIM_TypeDef"
     *   die zugehoerigen Bit-Definitionen
     *      TIM_CR1_CEN ::= Counter ENable                          siehe Abschnitt: "TIM / Bit definition for TIM_CR1 register"
     */
    // start action by starting timer
    TIM8->CR1 |= TIM_CR1_CEN;                                       // start timer                    {>RM0090 chap 17.3.4}
    // NOW read accesses on fifo are starting    
    GPIOI->BSRRL =  b(1) << 4;                                      // mark on LED that timer has started
    
    
    
    /*
     * Es folgt der Main-Loop.
     * Dier prueft der Reihe nach, ob ein Task zu erledigen ist und falls dies der Fall ist, arbeitet er den jeweiligen Task ab.
     * Die Summe der Ausfuehrungszeiten aller Tasks ist der WorstCase und bestimmt die Reaktionszeit, die zugesichert werden kann.
     */
    // NEVER stop doing task(s)
    while(1){
        // Es wird zyklisch geprueft, ob ein Task zu tun ist und falls ja, dann wird er getan
        
        /*
         * Der 1.Task:
         */
        // keep fifo filled
        if( fifoNextWrIndx != fifoRdIndx ){                         // is fifo full?
            // there is still place left inside fifo for data
            
            // write into fifo
            fifoWrIndx = fifoNextWrIndx;                            // update FIFO Write INDeX
            fifo[ fifoWrIndx ] = signalTable[ sigTabIndx >> 20 ];   // write value into fifo
            
            // update SIGNAL TABle INDeX
            if( sigTabIndx < MAX_INDX ){                            // already at end of table?
                sigTabIndx += DELTA;                                // NO -> increment
            }else{                                                  //
                sigTabIndx = 0;                                     // YES -> start again at beginning (for accurate frequency NOT round rotating)
            }//if
            
            // compute next FIFO WRite INDeX
            fifoNextWrIndx = (fifoWrIndx + 1) & FIFO_INDX_MSK;      // cyclic increment
        }//if
        
        
        
        /*
         * Der 2.Task:
         */
        // in case of fifo underflow  signal it
        if( fifoUnderflow ){
            GPIOI->BSRRH = b(1) << 7;                               // clear OK, since fifo underflow detected
            GPIOI->BSRRL = b(1) << 6;                               // mark ERROR (fifo underflow was detected)
        }//if
        
        /*
         * Der 3.Task:
         */
        if( spuriousInterrupt ){
            GPIOI->BSRRL = b(1) << 5;                               // mark ERROR (spurious interrupt was detected)
        }//if
        
        
        
        /*
         * Der 4.Task:
         */
        // switch S8 controls start/stop of timer
        if( S8 ){
            TIM8->CR1 ^= TIM_CR1_CEN;                               // start / stop timer
            GPIOI->ODR ^= b(1) << 4;                                // update related LED
        }//if        
        
        
        /*
         * Der 5.Task:
         */
        // switch S7 controls reset of fifo underflow state and false interrupt detected state  and enables timer (it might be disabled before)
        if( S7 ){
            TIM8->CR1 |= TIM_CR1_CEN;                               // start timer                    {>RM0090 chap 17.3.4}
            //
            fifoUnderflow  =  0;                                    // clear FIFO UNDERFLOW state
            spuriousInterrupt = 0;                                  // clear spurious interrupt state
            //
            GPIOI->BSRRL = b(1001) << 4;                            // set:  OK (NO fifo underflow yet)  and  timer enabled
            GPIOI->BSRRH = b(11) << 5;                              // clear LEDs marking fifo underflow and spurious interrupt state
        }//if
        
        
        
        
        
#ifdef TEST_SUPPORT_ENABLE
        //
        // "features" for testing
        // ======================
        
        /*
         * Der 6.Task:
         */
        // clear LEDs  if requested by user
        if( S6 ){
            GPIOI->BSRRH = b(1111) << 4;                            // clear LED 7&6&5&4 connected to GPIOI(7:4)
        }//if
        
        /*
         * Der 7.Task:
         */
        // set LEDs  if requested by user
        if( S5 ){
            GPIOI->BSRRL = b(1111) << 4;                            // set LED 7&6&5&4 connected to GPIOI(7:4)
        }//if
        
        /*
         * Der 8.Task:
         * Achtung, da dies ein Test-Task ist, der einen Underflow provozieren soll, macht er Busy-Waiting
         * Dieser Task verletzt die Bedingungen, wie sie Eingangs zum Main-Loop erklaert wurden.
         * Sofern dieser Task aktiviert wird, kann KEINE Reaktionszeit mehr zugesichert werden.
         */
        // trap computation
        while( S4 );                                                // freeze  - will produce fifo underfloe
#endif
    }//while
    
    
    
    
    
#ifdef FINAL_CATCH_FOR_SAFETYS_SAKE_ENABLE
    /*
     * Die folgende Code-Zeilen sind eigentlich unnoetig.
     * 1) Es wird der Timer8 disabled.
     * 2) Und schliesslich folgt eine "Sicherheitszeile", die bewusst unmittelbar vor der schliessenen Klammer der main-Funktion steht.
     *      Sofern "alles richtig gemacht" wird, wird diese Zeile NIEMALS erreicht (und/oder benoetigt).
     *      Daher produziert diese Zeilen "unreachable"-warnings
     */
    //------------------------------------------------------------------------
    // it is NOT expected that program execution passes here
    // anyway,
    
    // disable interrupt for Timer8 IRQ
    TIM8->DIER &= ~TIM_DIER_UIE;                                    // disable IRQ ;  timer8 will NOT send out IRQs anymore       {>RM0090 chap 17.4.4}
    NVIC_DisableIRQ( TIM8_UP_TIM13_IRQn );                          // disable IRQ ;  IRQ will NOT be granted by NVIC anymore
    NVIC_ClearPendingIRQ( TIM8_UP_TIM13_IRQn );                     // clear pending IRQs ;  just in case there are any left
    // now the interrupts related to timer8 are switched off
    
    // GUARD CODE  -  NEVER STOP !!!  -  THERE IS NO REST              will produce "loop is not reachable" warning
    while(1);
#endif
}//main()





/*
 * TFT info
 * ========
 *
 * Das TFT-Display laeuft ueber einen I2C-Bus.
 * Der I2C-Bus ist nicht schnell genug um beliebig viele Zeichen mit "µC-Full-Speed" zu uebertragen
 * Um das Beispiel NICHT unnoetig auszublaehen, wird auf eine saubere Loesung verzichtet, als da waeren
 *   Status des "I2C-Blocks" abfragen
 *   Timer programmieren, der korrektes Tempo sicherstellt und diesen auswerten
 * Sondern
 *   in einer Schleife Zeit vertroedelt.
 * Achtung! In serioesen Code ist das eine GANZ SCHLECHTE Idee und NICHT zulaessig!
 * Timer wurden bewusst eingefuehrt um genau so etwas zu vermeiden.
 *
 * Fuer weitere Informationen siehe:
 *  {> TI2 GS }
 *  {> tft.h }
 */
void showInfoOnTFT(void){
    uint8_t lineCntTFT;                                             // Y-position on TFT
    uint64_t dawdle;                                                // to DAWDLE away time - ATTENTION: this is VERY BAD coding style ;  _???_<150522> find better solution that is well suited for beginners
    
    TFT_cls();
    lineCntTFT = 1;
    TFT_gotoxy( 1, lineCntTFT );
    TFT_puts( "CE-Demo:" );
    lineCntTFT++;
    TFT_gotoxy( 1, lineCntTFT );
    TFT_puts( "Sending waveform via ISR to DAC" );
    lineCntTFT++;
    TFT_gotoxy( 1, lineCntTFT );
    TFT_puts( THE_VERY_C_CODE_VERSION );
    lineCntTFT+=2;
    for( dawdle=0; dawdle<1000000; dawdle++ );                      // dawdle away time, since I2C is too slow - ATTENTION: this is VERY BAD coding style ;  _???_<150522> find better solution that is well suited for beginners
    //
    TFT_gotoxy( 1, lineCntTFT );
    TFT_puts( "Switch S8: start/stop timer" );
    lineCntTFT++;
    TFT_gotoxy( 1, lineCntTFT );
    TFT_puts( "Switch S7: (re-)initialize state&LEDs" );
    lineCntTFT++;
#ifdef TEST_SUPPORT_ENABLE
    TFT_gotoxy( 1, lineCntTFT );
    TFT_puts( "Switch S6: clear LEDs" );
    lineCntTFT++;
    TFT_gotoxy( 1, lineCntTFT );
    TFT_puts( "Switch S5: set LEDs" );
    lineCntTFT++;
    TFT_gotoxy( 1, lineCntTFT );
    TFT_puts( "Switch S4: trap computation" );
    lineCntTFT++;
#endif
    for( dawdle=0; dawdle<1000000; dawdle++ );                      // dawdle away time, since I2C is too slow - ATTENTION: this is VERY BAD coding style ;  _???_<150522> find better solution that is well suited for beginners
    //
    TFT_gotoxy( 1, lineCntTFT );
    TFT_puts( "LED (PI7): OK - no error yet" );
    lineCntTFT++;
    TFT_gotoxy( 1, lineCntTFT );
    TFT_puts( "LED (PI6): FIFO underflow" );
    lineCntTFT++;
    TFT_gotoxy( 1, lineCntTFT );
    TFT_puts( "LED (PI5): Spurious interrupt" );
    lineCntTFT++;
    TFT_gotoxy( 1, lineCntTFT );
    TFT_puts( "LED (PI5): Timer enabled" );
    lineCntTFT++;
    for( dawdle=0; dawdle<1000000; dawdle++ );                      // dawdle away time, since I2C is too slow - ATTENTION: this is VERY BAD coding style ;  _???_<150522> find better solution that is well suited for beginners
    //
    TFT_gotoxy( 1, lineCntTFT );
}//showInfoOnTFT()
