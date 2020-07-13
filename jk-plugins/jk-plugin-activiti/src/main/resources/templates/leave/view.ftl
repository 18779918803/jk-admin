<#include "/common/layoutForm.ftl">
<@header></@header>
<@body >
    <div class="wrapper">
        <section class="content">
            <div class="row">
                <div class="col-md-12">
                    <form role="form" class="form-horizontal krt-form" id="krtForm">
                        <div class="box-body">
                            <div class="row">
                                <div class="col-sm-12">
                                    <div class="form-group">
                                        <label for="pname" class="control-label col-sm-2">
                                            <span class="form-required">*</span>申请人：
                                        </label>
                                        <div class="col-sm-10">
                                            <input type="text" id="title" name="title" value="${leave.applyUser!}"
                                                   class="form-control" required>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-sm-12">
                                    <div class="form-group">
                                        <label for="pname" class="control-label col-sm-2">
                                            <span class="form-required">*</span>申请时间：
                                        </label>
                                        <div class="col-sm-10">
                                            <div class="input-group input-group-addon-right-radius">
                                                <input type="text" class="form-control pull-right" name="applyTime"
                                                       id="applyTime"
                                                       value="${(leave.applyTime?string("yyyy-MM-dd"))!}"
                                                       readonly onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})"
                                                       required>
                                                <div class="input-group-addon">
                                                    <i class="fa fa-calendar"></i>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>


                            <div class="row">
                                <div class="col-sm-12">
                                    <div class="form-group">
                                        <label for="pname" class="control-label col-sm-2">
                                            <span class="form-required">*</span>标题：
                                        </label>
                                        <div class="col-sm-10">


                                            <input type="text" id="title" name="title" value="${leave.title!}"
                                                   class="form-control" required>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-sm-12">
                                    <div class="form-group">
                                        <label for="pname" class="control-label col-sm-2">
                                            <span class="form-required">*</span>原因：
                                        </label>
                                        <div class="col-sm-10">
                                            <textarea rows="2" name="reason" class="form-control"
                                                      required>${leave.reason!}</textarea>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-sm-12">
                                    <div class="form-group">
                                        <label for="pname" class="control-label col-sm-2">
                                            <span class="form-required">*</span>开始时间：
                                        </label>
                                        <div class="col-sm-10">
                                            <div class="input-group input-group-addon-right-radius">
                                                <input type="text" class="form-control pull-right" name="startTime"
                                                       id="startTime"
                                                       value="${(leave.startTime?string("yyyy-MM-dd"))!}"
                                                       readonly onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})"
                                                       required>
                                                <div class="input-group-addon">
                                                    <i class="fa fa-calendar"></i>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-sm-12">
                                    <div class="form-group">
                                        <label for="pname" class="control-label col-sm-2">
                                            <span class="form-required">*</span>结束时间：
                                        </label>
                                        <div class="col-sm-10">
                                            <div class="input-group input-group-addon-right-radius">
                                                <input type="text" class="form-control pull-right" name="endTime"
                                                       id="endTime"
                                                       value="${(leave.endTime?string("yyyy-MM-dd"))!}"
                                                       readonly onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})"
                                                       required>
                                                <div class="input-group-addon">
                                                    <i class="fa fa-calendar"></i>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-sm-12">
                                    <div class="form-group">
                                        <label for="pname" class="control-label col-sm-2">
                                            <span class="form-required">*</span>请假时长，单位秒：
                                        </label>
                                        <div class="col-sm-10">
                                            <input type="text" id="totalTime" name="totalTime"
                                                   value="${leave.totalTime!}" class="form-control" required>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- 隐藏域 -->
                            <input type="hidden" name="id" id="id" value="${leave.id!}">
                        </div>
                    </form>
                </div>
            </div>
        </section>
    </div>
</@body>
<@footer>
    <script type="text/javascript">
        var validateForm;
        $(function () {
            //验证表单
            validateForm = $("#krtForm").validate({});

        });

        <#--//提交-->
        <#--function doSubmit() {-->
            <#--krt.ajax({-->
                <#--type: "POST",-->
                <#--url: "${basePath}/activiti/leave/update",-->
                <#--data: $('#krtForm').serialize(),-->
                <#--validateForm: validateForm,-->
                <#--success: function (rb) {-->
                    <#--krt.layer.msg(rb.msg);-->
                    <#--if (rb.code === 200) {-->
                        <#--var index = krt.layer.getFrameIndex(); //获取窗口索引-->
                        <#--krt.table.reloadTable();-->
                        <#--krt.layer.close(index);-->
                    <#--}-->
                <#--}-->
            <#--});-->
        }
    </script>
</@footer>

