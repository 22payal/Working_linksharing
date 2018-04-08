//package linksharing
//
//class EmailsenderJob {
//    static triggers = {
//     // simple repeatInterval: 5000l // execute job once in 5 seconds
//
//        simple name: 'simpleTrigger', startDelay: 10000, repeatInterval: 30000, repeatCount: 10
//        cron name:   'cronTrigger',   startDelay: 10000, cronExpression: '0/6 * 15 * * ?'
//        custom name: 'customTrigger', triggerClass: MyTriggerClass, myParam: myValue, myAnotherParam: myAnotherValue
//    }
//
//    def execute() {
//        // execute job
//        print "Job run!"
//    }
//}
//
