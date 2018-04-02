package linksharing

class ReadingItemController {

    def index() { }

    def changeisRead(Long id, Boolean isRead){
             if(ReadingItem.executeUpdate("UPDATE RadingItem set isRead=:isRead where id=:id",
                     [isRead:isRead, id:id])){
                     render("SUCCESS")
                    }
               else
                    render("ERROR")

                   }

}
