<html>
<#include "../common/header.ftl">

    <body>

    <div id="wrapper" class="toggled">

        <#--边栏sidebar-->
        <#include "../common/nav.ftl">

        <#--主要内容content-->
        <div id="page-content-wrapper">
            <div class="container">
                <div class="row clearfix">
                    <div class="col-md-12 column">
                        <table class="table table-bordered table-hover table-condensed">
                            <thead>
                            <tr>
                                <th>订单id</th>
                                <th>姓名</th>
                                <th>手机号</th>
                                <th>地址</th>
                                <th>金额</th>
                                <th>订单状态</th>
                                <th>支付状态</th>
                                <th>创建时间</th>
                                <th colspan="2">操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <#list orderDTOPage.content as orderDTO>
                                <tr>
                                    <td>${orderDTO.orderId}</td>
                                    <td>${orderDTO.buyerName}</td>
                                    <td>${orderDTO.buyerPhone}</td>
                                    <td>${orderDTO.buyerAddress}</td>
                                    <td>${orderDTO.orderAmount}</td>
                                    <td>${orderDTO.orderStatusEnum.message}</td>
                                    <td>${orderDTO.paystatusEnum.message}</td>
                                    <td>${orderDTO.createTime}</td>
                                    <td><a href="/sell/seller/order/detail?orderId=${orderDTO.orderId}" >详情</a></td>
                                    <td>
                                        <#if orderDTO.orderStatusEnum.message == "新订单">
                                            <a href="/sell/seller/order/cancel?orderId=${orderDTO.orderId}">取消</a>
                                        </#if>
                                    </td>
                                </tr>
                            </#list>
                            </tbody>
                        </table>
                    </div>
                    <#--分页-->
                    <div class="col-md-12 column">
                        <ul class="pagination pull-right">
                            <#--如果当前页小于等于1，上一页不可点击-->
                            <#if currentPage lte 1>
                                <li class="disabled"><a href="#">首页</a></li>
                                <li class="disabled"><a href="#">上一页</a></li>
                            <#else>
                                <li><a href="/sell/seller/order/list?page=1&size=${size}">首页</a></li>
                                <li><a href="/sell/seller/order/list?page=${currentPage - 1}&size=${size}">上一页</a></li>
                            </#if>
                            <#list 1..orderDTOPage.totalPages as index >
                                <!--当前页不可点击-->
                                <#if currentPage == index>
                                    <li class="disabled"><a href="#">${index}</a></li>
                                    <!--如果循环到了当前页加上限制显示条数(该例为前后各显示5条)，之后的循环不在进行-->
                                <#elseif index gt currentPage+5>
                                    <li><a href="#">...</a></li>
                                    <#break >
                                    <!--如果循环在当前页减去限制显示条数(该例为前后各显示5条)，处理放在下一个else之中，当前循环不进行任何操作-->
                                <#elseif index lt currentPage-5>
                                <#--<#continue >-->
                                    <!--处理放在这。正好到限制页的时候。显示...-->
                                <#elseif index == currentPage-5>
                                    <li><a href="#">...</a></li>
                                <#else >
                                    <li><a href="/sell/seller/order/list?page=${index}&size=${size}">${index}</a></li>
                                </#if>
                            </#list>
                            <#--如果当前页大于等于总页数，下一页不可点击-->
                            <#if currentPage gte orderDTOPage.totalPages>
                                <li class="disabled"><a href="#">下一页</a></li>
                                <li class="disabled"><a href="#">尾页</a></li>
                            <#else>
                                <li><a href="/sell/seller/order/list?page=${currentPage + 1}&size=${size}">下一页</a></li>
                                <li><a href="/sell/seller/order/list?page=${orderDTOPage.totalPages}&size=${size}">尾页</a></li>
                            </#if>
                        </ul>
                    </div>
                </div>
            </div>
        </div>

    </div>


    <div class="modal fade" id="myModal" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                    <h4 class="modal-title" id="myModalLabel">
                        提醒
                    </h4>
                </div>
                <div class="modal-body">
                    你有新的订单
                </div>
                <div class="modal-footer">
                    <button onclick="javascript:document.getElementById('notice').pause()" type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button onclick="location.reload()" type="button" class="btn btn-primary">查看新的订单</button>
                </div>
            </div>
        </div>
    </div>

    <#--播放音乐-->
    <audio id="notice" loop="loop">
        <source src="/sell/mp3/song.mp3" type="audio/mpeg" />
    </audio>


    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

    <script>
        var websocket = null;
        if ('WebSocket' in window) {
            websocket = new WebSocket('ws://bizy.natapp1.cc/sell/webSocket');
        }else{
            alert("该浏览器不支持websocket");
        }

        websocket.onopen = function (event) {
            console.log('建立连接');
        }

        websocket.onclose = function (event) {
            console.log('连接关闭');
        }

        websocket.onmessage = function (event) {
            console.log('收到消息:' + event.data);
            //弹窗提醒，播放音乐
            $('#myModal').modal('show');

            document.getElementById('notice').play();
        }
        
        websocket.onerror = function () {
            alert('websocket通信发生错误!');
        }
        
        websocket.onbeforeunload = function () {
            websocket.close();
        }
    </script>

    </body>
</html>