import romantoarabic.groovy.Converter
import spock.lang.Specification
import spock.lang.Unroll

/**
 * User: mbednar
 * Date: 11.09.14
 * Time: 10:33
 */
class RomanToArabicNumbersTest extends Specification {
    @Unroll
    def "Convert Roman number (#roman) to arabic number (#arabic)."() {
        setup:
        def converter = new Converter()
        expect:
        converter.convertToArabic(roman) == arabic
        where:
        arabic | roman
        1      | "I"
        2      | "II"
        3      | "III"
        4      | "IV"
        5      | "V"
        6      | "VI"
        7      | "VII"
        8      | "VIII"
        9      | "IX"
        10     | "X"
        50     | "L"
        100    | "C"
        500    | "D"
        1000   | "M"
        999    | "CMXCIX"
        899    | "DCCCXCIX"
        799    | "DCCXCIX"
        765    | "DCCLXV"
        111    | "CXI"
        222    | "CCXXII"
        45     | "VL"
    }

    @Unroll
    def "Convert arabic number (#arabic) to roman number (#roman)."() {
        setup:
        def converter = new Converter()
        expect:
        roman == converter.convertToRoman(arabic)
        where:
        arabic | roman
        1      | "I"
        2      | "II"
        3      | "III"
        4      | "IV"
        5      | "V"
        6      | "VI"
        7      | "VII"
        8      | "VIII"
        9      | "IX"
        10     | "X"
        50     | "L"
        100    | "C"
        500    | "D"
        1000   | "M"
        999    | "CMXCIX"
        899    | "DCCCXCIX"
        799    | "DCCXCIX"
        765    | "DCCLXV"
        111    | "CXI"
        222    | "CCXXII"
    }

}
