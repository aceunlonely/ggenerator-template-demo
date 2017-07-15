// should be a map
var _templateEngineExt= {};

//首字母小写处理
_templateEngineExt.firstLowerCase = function(A){
    return A.replace(/(\w)/,function(v){return v.toLowerCase()});
}

_templateEngineExt.firstUpperCase = function(A){
    return _templateEngineExt.getDcm(A).replace(/(\w)/,function(v){return v.toUpperCase()});
}

//处理常量
_templateEngineExt.getDcm = function(str){
    var arr =[];

    var list = str.toUpperCase().split('_');
    for(var i=0;i<list.length;i++){
        arr.push(_templateEngineExt.firstUpperCase(list[i]))
    }
    return _templateEngineExt.firstLowerCase(arr.join(""));
}

function strContains(a, obj) {
    var i = a.length;
    while (i--) {
       if (a[i] === obj) {
           return true;
       }
    }
    return false;
}

//contains
_templateEngineExt.contains =function(val,list){
    var array = list.split(',');
    return strContains(list,val);
}


//controls
_templateEngineExt.generateIndexControls = function(di)
{
    /*{
                "SCALE": "0",
                "FIELDNAME": "JUDGE_DATE",
                "PRIMARYKEY": "0",
                "INTLENGTH": "23",
                "TABLENAME": "T_ZJGL_CERT_LIST_IMG",
                "FILEDINDEX": "12",
                "FIELDDESC": "判定日期",
                "LENGTH": "23",
                "DBTYPE": "datetime",
                "ISNULL": "1",
                "COMLENGTH": "23.0",
                "controlType": "1",
                "codeType": "",
                "importColumnType": "1",
                "isTableShow": "Y",
                "isQueryConditionShow": "Y",
                "isEditShow": "Y"
            }*/
    //{ "1" : "非公共代码库类型" ,"autocomplete" :"autocomplete" ,"select" :"select","m-select":"m-select" ,"m-checkbox":"m-checkbox","radio":"radio"};
    var dcm = _templateEngineExt.getDcm(di.FIELDNAME);
    var type =di.controlType;
    switch(di.controlType){
        case "1":
            type="textbox";
            break;
        case "autocomplete":
            if(di.codeType && di.codeType != "")
            {
                type = "code-autocomplete";
            }
            break;
    }
    var control ='<input id="s_' + dcm +'" dcc="'+type+'" dcm="'+ dcm+'" />';
    //日期判断
    if(di.DBTYPE == 'datetime' || di.DBTYPE == 'date')
    {
        control = '<input id="s_'+dcm+'Begin" dcc="datebox" dcm="'+dcm+'Begin" />~<input id="s_'+dcm+'End" dcc="datebox" dcm="'+dcm+'End" />'
    }
    else if(di.DBTYPE =="number" || di.DBTYPE =="numeric"  )
    {
        control ='<input id="s_' + dcm +'" dcc="'+"decimalbox"+'" dcm="'+ dcm+'" />';
    }
    else if(di.DBTYPE =="long" || di.DBTYPE == "int" )
    {
        control ='<input id="s_' + dcm +'" dcc="'+"intbox"+'" dcm="'+ dcm+'" />';
    }
    return control;
}

//controls
_templateEngineExt.generateHeadControls = function(di)
{
    /*{
                "SCALE": "0",
                "FIELDNAME": "JUDGE_DATE",
                "PRIMARYKEY": "0",
                "INTLENGTH": "23",
                "TABLENAME": "T_ZJGL_CERT_LIST_IMG",
                "FILEDINDEX": "12",
                "FIELDDESC": "判定日期",
                "LENGTH": "23",
                "DBTYPE": "datetime",
                "ISNULL": "1",
                "COMLENGTH": "23.0",
                "controlType": "1",
                "codeType": "",
                "importColumnType": "1",
                "isTableShow": "Y",
                "isQueryConditionShow": "Y",
                "isEditShow": "Y"
            }*/
    //{ "1" : "非公共代码库类型" ,"autocomplete" :"autocomplete" ,"select" :"select","m-select":"m-select" ,"m-checkbox":"m-checkbox","radio":"radio"};
    var dcm = _templateEngineExt.getDcm(di.FIELDNAME);
    var type =di.controlType;
    switch(di.controlType){
        case "1":
            type="textbox";
            break;
        case "autocomplete":
            if(di.codeType && di.codeType != "")
            {
                type = "code-autocomplete";
            }
            break;
    }
    var control ='<input id="d_' + dcm +'" dcc="'+type+'" dcm="'+ dcm+'" />';
    //日期判断
    if(di.DBTYPE == 'datetime' || di.DBTYPE == 'date')
    {
        control = '<input id="d_'+dcm+'" dcc="datebox" dcm="'+dcm+'" />'
    }
    else if(di.DBTYPE =="number" || di.DBTYPE =="numeric" )
    {
        control ='<input id="d_' + dcm +'" dcc="'+"decimalbox"+'" dcm="'+ dcm+'" />';
    }
    else if(di.DBTYPE =="long" || di.DBTYPE == "int" )
    {
        control ='<input id="d_' + dcm +'" dcc="'+"intbox"+'" dcm="'+ dcm+'" />';
    }
    return control;
}


//controls
_templateEngineExt.generateFieldValid = function(di)
{
    /*{
                "SCALE": "0",
                "FIELDNAME": "JUDGE_DATE",
                "PRIMARYKEY": "0",
                "INTLENGTH": "23",
                "TABLENAME": "T_ZJGL_CERT_LIST_IMG",
                "FILEDINDEX": "12",
                "FIELDDESC": "判定日期",
                "LENGTH": "23",
                "DBTYPE": "datetime",
                "ISNULL": "1",
                "COMLENGTH": "23.0",
                "controlType": "1",
                "codeType": "",
                "importColumnType": "1",
                "isTableShow": "Y",
                "isQueryConditionShow": "Y",
                "isEditShow": "Y"
            }*/
    //{ "1" : "非公共代码库类型" ,"autocomplete" :"autocomplete" ,"select" :"select","m-select":"m-select" ,"m-checkbox":"m-checkbox","radio":"radio"};

    //"hbBaseNo": { name: "备案资料库编号", validType: ["length[12]"], required: true },
    /*"apprExgAmt": { name: "出口总值", validType: "number[13,5]" },
            "exCurr": { name: "出口币制", required: true },
            "importPeriod": { name: "进口期限", validType: 'date' },
            "expiryDate": { name: "有效日期", required: true, validType: 'date' },*/
    var dcm = _templateEngineExt.getDcm(di.FIELDNAME);
    var type =di.controlType;
    var result = '"' + dcm +'": { name: "' +di.FIELDDESC+ '"';
    switch(di.DBTYPE){
        case "varchar":
        case "nvarchar":
        case "nchar":
            //只有文本框时生成验证
            if(di.controlType =="1" && di.LENGTH)
            {
                result = result + ', validType: ["length[' + di.LENGTH + ']"]';
            }
            break;
        case "number":
        case "numeric":
            if(di.SCALE && di.INTLENGTH)
            {
                result = result + ', validType: ["number[' + di.INTLENGTH + ',' + di.SCALE + ']"]';
            }
            break;
        case "datetime":
        case "date":
            result = result + ', validType: ["date"]';
            break;
        case "int":
        case "long":
            if(di.INTLENGTH)
            {
                result = result + ', validType: ["int[' + di.INTLENGTH+ ']"]';
            }
            else
            {
                result = result + ', validType: ["int"]';
            }
            break;
    }
    //是否可空
    if(di.ISNULL == "0")
    {
         result = result + ', required: true';
    }
    return result + " }";
}



_templateEngineExt.generateEntityField = function(di)
{
    /*{
                "SCALE": "0",
                "FIELDNAME": "JUDGE_DATE",
                "PRIMARYKEY": "0",
                "INTLENGTH": "23",
                "TABLENAME": "T_ZJGL_CERT_LIST_IMG",
                "FILEDINDEX": "12",
                "FIELDDESC": "判定日期",
                "LENGTH": "23",
                "DBTYPE": "datetime",
                "ISNULL": "1",
                "COMLENGTH": "23.0",
                "controlType": "1",
                "codeType": "",
                "importColumnType": "1",
                "isTableShow": "Y",
                "isQueryConditionShow": "Y",
                "isEditShow": "Y"
            }*/
    //{ "1" : "非公共代码库类型" ,"autocomplete" :"autocomplete" ,"select" :"select","m-select":"m-select" ,"m-checkbox":"m-checkbox","radio":"radio"};

    //"hbBaseNo": { name: "备案资料库编号", validType: ["length[12]"], required: true },
    /*"apprExgAmt": { name: "出口总值", validType: "number[13,5]" },
            "exCurr": { name: "出口币制", required: true },
            "importPeriod": { name: "进口期限", validType: 'date' },
            "expiryDate": { name: "有效日期", required: true, validType: 'date' },*/
    var dcm = _templateEngineExt.getDcm(di.FIELDNAME);
    var type =di.controlType;
    var result = 'private ';
    switch(di.DBTYPE){
        case "varchar":
        case "nvarchar":
        case "nchar":
            result = result + ' String';
            break;
        case "number":
        case "numeric":
            result = result + ' BigDecimal';
            break;
        case "datetime":
        case "date":
            result = result + ' Date';
            break;
        case "int":
        case "long":
            result = result + ' Interger';
            break;
    }
    return result + ' '+ dcm +';';
}


// this is for templateEngine Ext to register
exports.templateEngineExt = _templateEngineExt;