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
}