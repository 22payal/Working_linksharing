//package linksharing
//
//class LogoutImplementController {
//
//    static defaultAction = "logout"
//    def index() {}
//
//    def logout() {
//        if (session.user) {
//            session.invalidate()
//        }
//            redirect(controller: 'Login', action: 'home')
//    }
//}