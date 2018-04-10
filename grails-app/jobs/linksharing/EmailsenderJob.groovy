package linksharing

import dto.EmailDTO
import groovy.transform.CompileStatic
import org.springframework.scheduling.annotation.Scheduled

class EmailsenderJob {
    boolean lazyInit = false

    UnreadItemService unreadItemService

    static triggers = {
//         simple repeatInterval: 5000l // execute job once in 5 seconds
//      simple name: 'simpleTrigger', startDelay: 10000, repeatInterval: 30000, repeatCount: 10
        cron name: 'cronTrigger', startDelay: 10000, cronExpression: '0 0 1 ? * MON *'
        
         cron name: 'cronDaily', startDelay: 10000, cronExpression:'0 0 12 1/1 * ? *'
//        custom name: 'customTrigger', triggerClass: MyTriggerClass, myParam: myValue, myAnotherParam: myAnotherValue
    }

    def execute() {

        unreadItemService.unreaditem()
        println("email sent ..!")
    }

}

