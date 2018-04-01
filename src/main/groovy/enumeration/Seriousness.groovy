package enumeration

enum Seriousness {

    SERIOUS, VERYSERIOUS, CASUAL
    static Seriousness convertSeriousness(String inputString) {
        inputString = inputString.toUpperCase()
        Seriousness seriousness = inputString

        return seriousness
    }

}