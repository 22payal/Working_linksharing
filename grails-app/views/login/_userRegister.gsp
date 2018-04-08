<asset:javascript src="jquery.validate.js"/>
<style>
.error {
    color: #ff0000;
}
</style>





<g:form id="#addUserForm" controller="login" action="register" method="post">



    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="addUserModalLabel">New User</h4>
    </div>


    <div class="form-group col-lg-10">
        <label>First Name</label>
        <input class="form-control" type="text" name="firstName" placeholder="enter your first name">
    </div><div class="col-lg-2"></div>
    <div class="form-group col-lg-10">
        <label>Last name </label>
        <input class="form-control" type="text" name="lastName" placeholder="enter your last name">

    </div>
    <div class="form-group col-lg-10">
        <label>Email </label>
        <input class="form-control" type="email" name="email" placeholder="enter your email">

    </div>
    <div class="form-group col-lg-10">
        <label>Username </label>
        <input class="form-control" type="text" name="userName" >

    </div>

    <div class="form-group col-lg-10">
        <label>Password </label>
        <input class="form-control" type="password" name="password" placeholder="enter password">

    </div>
    <div class="form-group col-lg-10">
        <label>Confirm Password </label>
        <input class="form-control" type="password" name="confirmPassword" placeholder="confirm your  password">

    </div>

    <div class="form-group col-lg-10 row">
        <label>Photo</label>
        <input class="form-control" type="file" name="photo">

    </div>

    <div  class="form-group col-lg-10">
        <input type="submit" class="form-control btn-primary" style="background:#007efc">
    </div>


</g:form>


<script type="text/javascript">
    $(document).ready(function () {

        $("#addUserForm").validate({
            debug: true,
            rules: {
                firstName: {
                    required: true
                },
                lastName: {
                    required: true
                },
                email: {
                    email: true,
                    required: true,
                    remote:"/validation/isEmailExists"
                },
                userName: {
                    required: true,
                    remote: "/validation/isUsernameExists"
                },
                password: {
                    required: true,
                    minlength: 5
                }
            },
            messages: {
                email: {
                    remote: jQuery.validator.format("email with {0} already exists.")
                },
                userName:{
                    remote: jQuery.validator.format("user name with {0} already exists.")
                }
            },
            submitHandler: function (form) {
                var isValidForm = $("#addUserForm").valid();
                if (isValidForm) {
                    $(".loader").toggleClass("hidden");
                    var data = {
                        firstName: $("#firstName").val(),
                        lastName: $("#lastName").val(),
                        userName: $("#userName").val(),
                        password: $("#password").val(),
                        email: $("#email").val()
                    };

                    $.post(form.action, data, onUserRegister);
                }
            }
        });

        var onUserRegister = function (user) {
            $("#addUserModalLabel").html("Success");
            $(".modal-body").html("Your registration with name <b>" + user.userName + "</b> has been saved");
            $(".modal-footer").remove();
        };

    });

</script>
