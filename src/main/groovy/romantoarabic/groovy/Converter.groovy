package romantoarabic.groovy

/**
 * User: mbednar
 * Date: 11.09.14
 * Time: 10:41
 */
class Converter {
    def roman2arabic = [
            'I': 1,
            'V': 5,
            'X': 10,
            'L': 50,
            'C': 100,
            'D': 500,
            'M': 1000
    ]

    def arabic2roman = (roman2arabic + [
            'CM': 900,
            'CD': 400,
            'XC': 90,
            'XL': 40,
            'IX': 9,
            'IV': 4
    ]).collect { e -> new MapEntry(e.value, e.key) }.sort { a, b -> -1 * (a.key <=> b.key) }

    def convertToArabic(String romanNumber) {
        def romanNumbers = romanNumber.toCharArray() as List
        convertToArabicRecursive(romanNumbers.head(), romanNumbers.tail())
    }

    private convertToArabicRecursive(Character firstElement, List<Character> romanNumbers) {

        final arabicNumber = roman2arabic[firstElement.toString()]

        if (romanNumbers.isEmpty())
            return arabicNumber

        int nextArabic = roman2arabic[romanNumbers.head().toString()]
        if (arabicNumber < nextArabic)
            if (romanNumbers.tail().isEmpty())
                return nextArabic - arabicNumber
            else
                return convertToArabicRecursive(romanNumbers.tail().head(), romanNumbers.tail().tail()) + nextArabic - arabicNumber
        else
            return convertToArabicRecursive(romanNumbers.head(), romanNumbers.tail()) + arabicNumber
    }

    def convertToRoman(int i) {
        convertToRomanRecursive(i, arabic2roman.head(), arabic2roman.tail())
    }

    def convertToRomanRecursive(int i, Map.Entry entry, List<MapEntry> entries) {
        if (i == 0) {
            def object = i == entry.key ? entry.value : ""
            return object
        }

        if (i.mod(entry.key) < i) {
            def var = entry.value + convertToRomanRecursive(i - entry.key, entry, entries)
            return var
        } else {
            def var = convertToRomanRecursive(i, entries.head(), entries.tail())
            return var
        }
    }
}