<%@ page import="linksharing.Topic" %>
<div id="myModal2" class="modal fade" role="dialog">
    <div class="modal-dialog">


        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">send invitation</h4>
            </div>
            <div class="modal-body row">
                <g:form controller="topic" action="invite" method="post">
                    <div class="form-group" >
                        <div class="form-group col-lg-10">
                        <label class="control-label col-sm-2">Email:</label>

                        <div class="col-sm-10">
                        <input class="form-control" type="email" name="to" placeholder="enter the email of the receipent">

                        </div>
                    </div>
                 <span class="caret"></span>

                    <g:select name="topicName" from="${Topic.getTopicName(session.user)}" value="topicName" > Topics</g:select>

                    <br>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            %{--<button type="submit" class="btn btn-default"> Invite </button>--}%
                            <g:submitButton name="Share" value="Invite">Invite</g:submitButton>
                            <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                        </div>
                        </div>
                </g:form>

            </div>

        </div>

    </div>
</div>
</div>
