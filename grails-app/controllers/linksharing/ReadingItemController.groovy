package linksharing

class ReadingItemController {

    def index() { }

    def changeisRead(Long id, Boolean isRead){
        println("in reading item..")
        println(params.id)
        println(isRead)

             if(ReadingItem.executeUpdate("UPDATE RadingItem set isRead=:isRead where id=:id",
                     [isRead:isRead, id:id])){
                     render("SUCCESS")
                    }
               else
                    render("ERROR")

                   }

//    def changeisRead(Integer id, User user){
//
//        if(ReadingItem.executeUpdate("UPDATE RadingItem set isRead=:isRead where id=:id",
//                [isRead:isRead, id:id])){
//            render("SUCCESS")
//        }
//        else
//            render("ERROR")
//
//    }





}
