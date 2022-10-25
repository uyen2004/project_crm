
$(document).ready(function (){
    // alert("ok");

    //.class, #id
    //find(selector)
    //this đại diện cho thẻ đang có sự kiện click
    //parent(): đi ra parent của selector đang gọi
    //closest(): đi ra n cấp chỉ định (đi ra root)
    $(".btn-delete").click(function () {
        var id = $(this).attr("roleId")
        var This = $(this)
        $.ajax({
            method: "get",
            url: "http://localhost:8080/crm/api/role?id=" +id,
            //data: { name: "John", location: "Boston" }
        })
            .done(function( data ) {
                console.log(data)
                if(data.success){
                    //alert("Xoa thanh cong")
                    This.closest("tr").remove()
                }
            });
    })
    $(".btn-add").click(function () {
        var name = $("#name").val();
        var description = $("#description").val();
        var html =` <tr>
                        <td></td>
                        <td>name</td>
                        <td>ds</td>
                        <td>
                            <a href="#" class="btn btn-sm btn-primary btn-update">Sửa</a>
                            <a href="#" roleId = "" class="btn btn-sm btn-danger btn-delete">Xóa</a>
                        </td>
                     </tr>`
        $("#role-body").append(html);
    })

})