package enumeration

enum Visibility {
    PRIVATE ,PUBLIC

    static Visibility convertIntoEnum(String inputString) {
        inputString = inputString.toUpperCase()
        Visibility visibility = inputString

        return visibility
    }

}