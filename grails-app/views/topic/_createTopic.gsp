<%@ page import="enumeration.Visibility" %>
<div id="myModal" class="modal fade" role="dialog">
    <div class="modal-dialog">

        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">create topic</h4>
            </div>
            <div class="modal-body row ">
                <g:form controller="topic" action="save" method="post">
                    <div class="form-group">
                        <div class="form-group col-lg-10">
                            <label>TOPIC NAME : </label>
                            <input class="form-control" type="text" name="topicName" placeholder="enter name of your topic">

                        </div>

                    <div>

                            <span class="caret"></span>
                            <g:select name="visibility" from="${enumeration.Visibility.values()}" value="visibility" />
                    </div>
                          </div>

                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <g:submitButton name="Share" value="submit">share</g:submitButton>
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>

                        </div>
                    </div>
                </g:form>
            </div>
        </div>

    </div>
</div>