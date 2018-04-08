//package linksharing
//
//
//class LoginCheckInterceptor {
//    LoginCheckInterceptor()
//    {
//        matchAll().excludes(controller:'login')
//                .excludes(controller:'user')
//
//    }
//    boolean before() {
//        if (!session.user) {
//            flash.error= "NO ACTIVE SESSION"
//            redirect(controller:'login')
//        }
//
//    }
//
//    boolean after() { true }
//
//    void afterView() {
//        // no-op
//    }
//}
