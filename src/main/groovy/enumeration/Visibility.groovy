package enumeration

enum Visibility {
    PRIVATE(0) ,PUBLIC ( 1)


    final int value

    Visibility(Integer value)
    { this.value = value

    }
int getkey()
{
     value
}
    static Visibility convertIntoEnum(String inputString) {
        inputString = inputString.toUpperCase()
        Visibility visibility = inputString

        return visibility
    }

}