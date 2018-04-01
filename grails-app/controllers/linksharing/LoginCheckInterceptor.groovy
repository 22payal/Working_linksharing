package linksharing


class LoginCheckInterceptor {
    LoginCheckInterceptor()
    {
        matchAll().excludes(controller: 'Login')
    }
    boolean before() {
        if (!session.user) {
            flash.error= "NO ACTIVE SESSION"

        }

        true
    }

    boolean after() { true }

    void afterView() {
        // no-op
    }
}
