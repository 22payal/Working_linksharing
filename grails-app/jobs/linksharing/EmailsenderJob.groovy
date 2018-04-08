//package linksharing
//
//import dto.EmailDTO
//
//class EmailsenderJob {
//    boolean lazyInit = false
//
//
//    EmailService emailService
//
//    static triggers = {
//         simple repeatInterval: 5000l // execute job once in 5 seconds
//
//        simple name: 'simpleTrigger', startDelay: 10000, repeatInterval: 30000, repeatCount: 10
//        cron name: 'cronTrigger', startDelay: 10000, cronExpression: '0/6 * 15 * * ?'
//        custom name: 'customTrigger', triggerClass: MyTriggerClass, myParam: myValue, myAnotherParam: myAnotherValue
//    }
//
//    def execute() {
//        // execute job
//        print "Job run!"
//    }
//
//    def unreaditem() {
//        List<User> userList = User.findAll()
//        List <String> topicName = []
//
//        userList.each { user ->
//            List<ReadingItem> readingItemList = ReadingItem.findAllByUserAndIsRead(user, false)
//
//            readingItemList.resource.each { list ->
//
//                topicName.add(list.topic.topicName)
//            }
//
//                EmailDTO emailDTO = new EmailDTO(to: user.email, subject: "Unread items in inbox" , itemList: topicName)
//
//                emailService.sendUnreadResourcesEmail(emailDTO)
//
//        }
//        return
//    }
//}
//
