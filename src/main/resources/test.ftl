<html>
<head>
    <meta charset="UTF-8">
    <title>freemarker入门</title>
</head>
<body>
<#--注释  不会被写入html文件-->
<!--会被写入html文件的注释-->
${name},你好，${message}!
<#assign linkman="周先生">
联系人：${linkman}<br>
<#assign info={"mobile":"222220","address":"北京"}>
电话：${info.mobile} 地址：${info.address}
<#include "head.ftl">

<#if success=true>
    你已通过实名认证
<#else>
    你未通过实名认证
</#if>
<br>
<#list goodsList as goods>
    ${goods_index+1} 商品名称：${goods.name}  商品价格：${goods.price} <br>
</#list>
总共${goodsList?size}条

<br>
<#assign text="{'bank':'工商银行','account':'1656553254'}">
<#assign data=text?eval>
银行：${data.bank} 账户：${data.account}<br>

当前日期：${today?date}<br>
当前时间：${today?time}<br>
当前日期+时间：${today?datetime}<br>
格式化：${today?string("yyyy年MM月")}<br>

积分：${point}<br>
积分：${point?c}<br>

<#if aaa??>
    aaa变量存在
<#else >
   aaa变量不存在
</#if>
<br>
${aaa!'aaa not me'}
<br>

<#if 2 gt 1>
    2大于1
<#else >
    2小于1
</#if><br>
<#if (2 > 1)>
    2大于1
<#else >
    2小于1
</#if>
</body>
</html>