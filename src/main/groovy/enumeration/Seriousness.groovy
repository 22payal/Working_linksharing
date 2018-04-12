package enumeration

enum Seriousness {

    SERIOUS, VERYSERIOUS, CASUAL
//    static Seriousness convertSeriousness(String inputString) {
//        inputString = inputString.toUpperCase()
//        Seriousness seriousness = inputString
//
//        return seriousness
//    }

     static Seriousness convert(String str){
        if("VERYSERIOUS"==str.toUpperCase()){
            return Seriousness.VERYSERIOUS;
        }
        else if("SERIOUS"==str.toUpperCase())
            return Seriousness.SERIOUS;
        else
            return Seriousness.CASUAL;
    }

}