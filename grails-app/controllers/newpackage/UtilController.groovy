package newpackage

class UtilController {

    def index() {

        log.trace "hello world"
        log.error("error found")
        log.warn("warning started")
        log.info("info stated")
        log.debug("debugging started")

        log.info("request params: $params")

        render("hello user ")
    }



    def call(){
        //render(view: "/applicationLayout/discard")
        render(view: "/applicationLayout/select")

    }
}
