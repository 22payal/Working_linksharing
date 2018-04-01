package linksharing


class ApplicationInterceptor {

    ApplicationInterceptor()
    {
        matchAll()
    }
    boolean before() {
        if (!session.user) {
            flash.error= "NO ACTIVE SESSION"
            return false
        }

        else {
            log.info("ACTION AND CONTROLLER LOG: ${params.toString()}")
            true
        }
    }

    boolean after() {  log.info("ACTION AND CONTROLLER LOG: ${params.toString()}")
        true }

    void afterView() {
        // no-op
    }

}
