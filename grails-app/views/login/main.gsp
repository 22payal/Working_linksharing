<%@ page import="linksharing.Resource" %>
<!DOCTYPE html>
<html lang="en">
<head>

    <title></title>
    <meta name="layout" content="main">

</head>

<body>

<div class=" container">
    <div class="col-lg-6">
        <div class="col-lg-12" style="margin-top: 25px">


                    <div class=" panel panel-default     ">
                <div class="panel-heading " style="background:#007efc">
                    <p>

                    <h3 style="color:white">Recent Shares</h3></p>
                </div>

                <div class="panel-body  ">
                    <div class="col-lg-12">
                        <g:render template="/Resource/recentShares"></g:render>
                    </div>

                </div>
            </div>

        </div>

        <div class="col-lg-12" style="margin-top: 25px">

            <g:render template="/Resource/topPost"> </g:render>

        </div>


    </div>

    <div class="col-lg-6">
        <div class=" panel panel-default ">
            <div class="panel-heading " style="background:#007efc">
                <p>

                <h3 style="color:white">Login</h3></p>
            </div>
            <div class="panel-body ">


                <g:render template="userLogin"> </g:render>

            </div>

        </div>
        <div class=" panel panel-default ">
            <div class="panel-heading " style="background:#007efc">
                <p>

                <h3 style="color:white">Register</h3></p>
            </div>
            <div class="panel-body ">
                <g:render template="userRegister"> </g:render>
            </div>

        </div>



    </div>

    </div>

</div>

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script type="text/javascript">
    $(document).ready(function () {

        var loadModal = function () {
            $.post({url :"/login/register", success : function (response) {
                    $('#modalBody').html(response);
                }});
        };

        $('#loadModal').click(loadModal);
    });
</script>

</body>

</html>