<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
<legend>编辑笔记</legend>
<div class="layui-field-box">
<form class="layui-form" method="post" id='note' name='note'>
	<input type="hidden" name="noteID" value="${noteForm.noteID}">
	<div class="layui-form-item">
		<label class="layui-form-label">笔记标题</label>
		<div class="layui-input-block">
		<input name="noteTitle" class="layui-input" value="${noteForm.noteTitle}"/>
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">笔记类别</label>
		<div class="layui-btn-container">
		<c:forEach items="${allCategoryNameList}" var='allCategoryName'>
		<label class="layui-btn layui-btn-xs layui-bg-cyan" onclick='addCategory(this)'>
		${allCategoryName}
		</label>
		</c:forEach>
		</div>
		<div class="layui-input-block">
		<input name="categoryName" id="categoryName" class="layui-input" value="${noteForm.categoryName}"/>
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">标签</label>
		<div class="layui-btn-container">
			<c:forEach items="${allTagNameList}" var='allTagName'>
			<label class="layui-btn layui-btn-xs layui-bg-cyan" onclick='addTag(this)'>
			${allTagName}
			</label>
			</c:forEach>
		</div>
		<div class="layui-input-block">
		<input name="tagNames" id="tagNames" class="layui-input" value="
			<c:forEach items="${tagNameList}" var='tagName'>
			${tagName} # 
			</c:forEach>
		"/>
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">笔记内容</label>    
		<div class="layui-input-block">
		<textarea name="noteContent" id="noteContent">${noteForm.noteContent}</textarea>
		<c:remove var="noteForm"/>
		</div>
	</div>
	<div class="layui-form-item">
		<div class="layui-input-block">
		<button lay-submit class="layui-btn layui-btn-sm layui-bg-cyan" onclick="changeNote()">
		<i class='layui-icon layui-icon-edit'>更新笔记内容</i>
		</button>
		<button type="reset" class="layui-btn layui-btn-sm layui-bg-cyan" onclick="deleteNote()">
		<i class='layui-icon layui-icon-fonts-clear'>删除笔记内容</i>
		</button>
		</div>
	</div>
</form>
</div>
</fieldset>
<script src="${pageContext.request.contextPath}/resources/ckeditor/ckeditor.js"></script>
<script src="${pageContext.request.contextPath}/resources/ckeditor/zh-cn.js"></script>
<script>
ClassicEditor.create( document.querySelector('#noteContent'),{
	toolbar: ['heading','|','bold','italic','link','imageUpload','blockQuote'],
	language : 'zh-cn',
	ckfinder: {
		uploadUrl: '${pageContext.request.contextPath}/author/UploadNotePhotoServlet'
	}
} );
function changeNote(){
	document.note.action ="${pageContext.request.contextPath}/author/ChangeNoteServlet.tran";
	document.note.submit();
}
function deleteNote(){
	layui.use(['layer'], function() {
		var layer = layui.layer;
		layer.confirm('确定删除吗？', {
			btn: ['确定删除', '取消删除']
		}, function(){
			document.note.action ="${pageContext.request.contextPath}/author/DeleteNoteServlet.tran";
			document.note.submit();
		},function(){
		});
	});
}
var addCategory = function(btn){
	var value = btn.innerText;
 	var categoryName = document.getElementById("categoryName");
 	categoryName.value = value;
}
var addTag = function(btn){
	var value = btn.innerText;
 	var tagNames = document.getElementById("tagNames");
	var tagNameValues = tagNames.value;
	if(tagNameValues.indexOf(value) > -1) return;
	tagNames.value = tagNameValues + value + " # ";
}
</script>