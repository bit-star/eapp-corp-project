package com.service;

import com.alibaba.fastjson.JSON;
import com.config.Constant;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.*;
import com.dingtalk.api.response.*;
import com.google.common.collect.Lists;
import com.taobao.api.ApiException;
import com.util.AccessTokenUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OwnWorkflowService {

    public static void main(String[] args) {
//        createTemplate();
//        createInstance();
//        updateInstance();
//        createTodo();
//        updateTode();
        queryTodo("88888888");
    }


    public static void queryTodo(String userid) {
        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/topapi/process/workrecord/task/query");
        OapiProcessWorkrecordTaskQueryRequest req = new OapiProcessWorkrecordTaskQueryRequest();
        req.setUserid(userid);
        req.setOffset(0L);
        req.setCount(20L);
        req.setStatus(0L);
        OapiProcessWorkrecordTaskQueryResponse rsp = null;
        try {
            rsp = client.execute(req, AccessTokenUtil.getToken());
        } catch (ApiException e) {
            e.printStackTrace();
        }
        System.out.println(rsp.getBody());

    }

    public static void updateTode() {
        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/topapi/process/workrecord/task/update");
        OapiProcessWorkrecordTaskUpdateRequest req = new OapiProcessWorkrecordTaskUpdateRequest();
        OapiProcessWorkrecordTaskUpdateRequest.UpdateTaskRequest obj1 = new OapiProcessWorkrecordTaskUpdateRequest.UpdateTaskRequest();
        obj1.setAgentid(Constant.AGENTID);
        obj1.setProcessInstanceId("0e542e32-84e9-4cb4-ba27-7282eba65c41");
        List<OapiProcessWorkrecordTaskUpdateRequest.TaskTopVo> list3 = new ArrayList<OapiProcessWorkrecordTaskUpdateRequest.TaskTopVo>();
        OapiProcessWorkrecordTaskUpdateRequest.TaskTopVo obj4 = new OapiProcessWorkrecordTaskUpdateRequest.TaskTopVo();
        list3.add(obj4);
        obj4.setTaskId(62676974852L);
        obj4.setStatus("COMPLETED");
        obj4.setResult("agree");
        obj1.setTasks(list3);
        req.setRequest(obj1);
        OapiProcessWorkrecordTaskUpdateResponse rsp = null;
        try {
            rsp = client.execute(req, AccessTokenUtil.getToken());
        } catch (ApiException e) {
            e.printStackTrace();
        }
        System.out.println(rsp.getBody());

    }


    public static void createTodo() {
        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/topapi/process/workrecord/task/create");
        OapiProcessWorkrecordTaskCreateRequest req = new OapiProcessWorkrecordTaskCreateRequest();
        OapiProcessWorkrecordTaskCreateRequest.SaveTaskRequest obj1 = new OapiProcessWorkrecordTaskCreateRequest.SaveTaskRequest();
        obj1.setAgentid(Constant.AGENTID);
        obj1.setProcessInstanceId("0e542e32-84e9-4cb4-ba27-7282eba65c41");
        obj1.setActivityId("activity-zzz");
        List<OapiProcessWorkrecordTaskCreateRequest.TaskTopVo> list3 = new ArrayList<OapiProcessWorkrecordTaskCreateRequest.TaskTopVo>();
        OapiProcessWorkrecordTaskCreateRequest.TaskTopVo obj4 = new OapiProcessWorkrecordTaskCreateRequest.TaskTopVo();
        list3.add(obj4);
        obj4.setUserid("88888888");
        obj4.setUrl("https://www.dingtalk.com");
        obj1.setTasks(list3);
        req.setRequest(obj1);
        OapiProcessWorkrecordTaskCreateResponse rsp = null;
        try {
            rsp = client.execute(req, AccessTokenUtil.getToken());
        } catch (ApiException e) {
            e.printStackTrace();
        }
        System.out.println(rsp.getBody());
    }

    public static void updateInstance() {
        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/topapi/process/workrecord/update");
        OapiProcessWorkrecordUpdateRequest req = new OapiProcessWorkrecordUpdateRequest();
        OapiProcessWorkrecordUpdateRequest.UpdateProcessInstanceRequest obj1 = new OapiProcessWorkrecordUpdateRequest.UpdateProcessInstanceRequest();
        obj1.setAgentid(111L);
        obj1.setProcessInstanceId("31c3c6bd-6d66-4596-8b58-cb2e4b3e658e");
        obj1.setStatus("COMPLETED");
        obj1.setResult("agree");
        req.setRequest(obj1);
        OapiProcessWorkrecordUpdateResponse rsp = null;
        try {
            rsp = client.execute(req, AccessTokenUtil.getToken());
        } catch (ApiException e) {
            e.printStackTrace();
        }
        System.out.println(rsp.getBody());
    }

    public static void createInstance() {
        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/topapi/process/workrecord/create");
        OapiProcessWorkrecordCreateRequest req = new OapiProcessWorkrecordCreateRequest();
        OapiProcessWorkrecordCreateRequest.SaveFakeProcessInstanceRequest obj1 = new OapiProcessWorkrecordCreateRequest.SaveFakeProcessInstanceRequest();
        obj1.setAgentid(Constant.AGENTID);
        obj1.setProcessCode("PROC-CF416CB2-3CEB-4DBF-8F14-4DEB8EDFB1C0");
        obj1.setOriginatorUserId("17317366260");
        List<OapiProcessWorkrecordCreateRequest.FormComponentValueVo> list3 = new ArrayList<OapiProcessWorkrecordCreateRequest.FormComponentValueVo>();
        OapiProcessWorkrecordCreateRequest.FormComponentValueVo obj4 = new OapiProcessWorkrecordCreateRequest.FormComponentValueVo();
        obj4.setName("单行输入框");
        obj4.setValue("value");
        obj4.setExtValue("ext");
        list3.add(obj4);

        OapiProcessWorkrecordCreateRequest.FormComponentValueVo obj5 = new OapiProcessWorkrecordCreateRequest.FormComponentValueVo();
        obj5.setName("多行输入框");
        obj5.setValue("value");
        obj5.setExtValue("ext");
        list3.add(obj5);

        OapiProcessWorkrecordCreateRequest.FormComponentValueVo obj6 = new OapiProcessWorkrecordCreateRequest.FormComponentValueVo();
        obj6.setName("金额（元）大写");
        obj6.setValue("123");
        obj6.setExtValue("ext");
        list3.add(obj6);

        OapiProcessWorkrecordCreateRequest.FormComponentValueVo obj7 = new OapiProcessWorkrecordCreateRequest.FormComponentValueVo();
        obj7.setName("数字输入框带单位");
        obj7.setValue("456");
        obj7.setExtValue("ext");
        list3.add(obj7);



        OapiProcessWorkrecordCreateRequest.FormComponentValueVo obj8 = new OapiProcessWorkrecordCreateRequest.FormComponentValueVo();
        obj8.setName("日期");
        obj8.setValue("2019-11-12 14:52");
//        obj8.setExtValue("ext");
        list3.add(obj8);

        OapiProcessWorkrecordCreateRequest.FormComponentValueVo obj9 = new OapiProcessWorkrecordCreateRequest.FormComponentValueVo();
        obj9.setName("[\"a\",\"b\"]");
        obj9.setValue("[\"2019-11-10 14:52\",\"2019-11-12 14:52\"]");
//        obj9.setExtValue("ext");
        list3.add(obj9);


        obj1.setFormComponentValues(list3);
        obj1.setUrl("http://www.dingtalk.com");
        req.setRequest(obj1);
        OapiProcessWorkrecordCreateResponse rsp = null;
        try {
            rsp = client.execute(req, AccessTokenUtil.getToken());
        } catch (ApiException e) {
            e.printStackTrace();
        }
        System.out.println(rsp.getBody());
    }

    public static void createTemplate() {
        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/topapi/process/save");

        OapiProcessSaveRequest request = new OapiProcessSaveRequest();
        OapiProcessSaveRequest.SaveProcessRequest saveProcessRequest = new OapiProcessSaveRequest.SaveProcessRequest();
        saveProcessRequest.setDisableFormEdit(true);
        saveProcessRequest.setName("test2.0");
//        saveProcessRequest.setProcessCode("PROC-BE7FC6B2-E95B-45CA-AD9A-A62819EDA2FE");
        saveProcessRequest.setAgentid(Constant.AGENTID);
        saveProcessRequest.setFakeMode(true);

        // 注意，每种表单组件，对应的componentName是固定的，参照一下示例代码
        List<OapiProcessSaveRequest.FormComponentVo> formComponentList = Lists.newArrayList();

        // 单行文本框
        OapiProcessSaveRequest.FormComponentVo singleInput = new OapiProcessSaveRequest.FormComponentVo();
        singleInput.setComponentName("TextField");
        OapiProcessSaveRequest.FormComponentPropVo singleInputProp = new OapiProcessSaveRequest.FormComponentPropVo();
        singleInputProp.setRequired(true);
        singleInputProp.setLabel("单行输入框");
        singleInputProp.setPlaceholder("请输入");
        singleInputProp.setId("TextField-J78F056R");
        singleInput.setProps(singleInputProp);
        formComponentList.add(singleInput);

        // 多行文本框
        OapiProcessSaveRequest.FormComponentVo multipleInput = new OapiProcessSaveRequest.FormComponentVo();
        multipleInput.setComponentName("TextareaField");
        OapiProcessSaveRequest.FormComponentPropVo multipleInputProp = new OapiProcessSaveRequest.FormComponentPropVo();
        multipleInputProp.setRequired(true);
        multipleInputProp.setLabel("多行输入框");
        multipleInputProp.setPlaceholder("请输入");
        multipleInputProp.setId("TextareaField-J78F056S");
        multipleInput.setProps(multipleInputProp);
        formComponentList.add(multipleInput);

        // 金额组件
        OapiProcessSaveRequest.FormComponentVo moneyComponent = new OapiProcessSaveRequest.FormComponentVo();
        moneyComponent.setComponentName("MoneyField");
        OapiProcessSaveRequest.FormComponentPropVo moneyComponentProp = new OapiProcessSaveRequest.FormComponentPropVo();
        moneyComponentProp.setRequired(true);
        moneyComponentProp.setLabel("金额（元）大写");
        moneyComponentProp.setPlaceholder("请输入");
        moneyComponentProp.setId("MoneyField-J78F0571");
        moneyComponentProp.setNotUpper("1"); // 是否禁用大写
        moneyComponent.setProps(moneyComponentProp);
        formComponentList.add(moneyComponent);

        // 数字输入框
        OapiProcessSaveRequest.FormComponentVo numberComponent = new OapiProcessSaveRequest.FormComponentVo();
        numberComponent.setComponentName("NumberField");
        OapiProcessSaveRequest.FormComponentPropVo numberComponentProp = new OapiProcessSaveRequest.FormComponentPropVo();
        numberComponentProp.setRequired(true);
        numberComponentProp.setLabel("数字输入框带单位");
        numberComponentProp.setPlaceholder("请输入");
        numberComponentProp.setId("NumberField-J78F057N");
        numberComponentProp.setUnit("元");
        numberComponent.setProps(numberComponentProp);
        formComponentList.add(numberComponent);

        // 日期
        OapiProcessSaveRequest.FormComponentVo dateComponent = new OapiProcessSaveRequest.FormComponentVo();
        dateComponent.setComponentName("DDDateField");
        OapiProcessSaveRequest.FormComponentPropVo dateComponentProp = new OapiProcessSaveRequest.FormComponentPropVo();
        dateComponentProp.setRequired(true);
        dateComponentProp.setLabel("日期");
        dateComponentProp.setPlaceholder("请选择");
        dateComponentProp.setUnit("小时"); // 小时或天
        dateComponentProp.setId("DDDateField-J8MTJZVE");
        dateComponent.setProps(dateComponentProp);
        formComponentList.add(dateComponent);

        // 日期区间
        OapiProcessSaveRequest.FormComponentVo dateRangeComponent = new OapiProcessSaveRequest.FormComponentVo();
        dateRangeComponent.setComponentName("DDDateRangeField");
        OapiProcessSaveRequest.FormComponentPropVo dateRangeComponentProp = new OapiProcessSaveRequest.FormComponentPropVo();
        dateRangeComponentProp.setRequired(true);
        dateRangeComponentProp.setLabel(JSON.toJSONString(Arrays.asList("a", "b")));
        dateRangeComponentProp.setPlaceholder("请选择");
        dateRangeComponentProp.setUnit("小时"); // 小时或天
        dateRangeComponentProp.setId("DDDateRangeField-J78F057Q");
        dateRangeComponent.setProps(dateRangeComponentProp);
        formComponentList.add(dateRangeComponent);

        saveProcessRequest.setFormComponentList(formComponentList);
        request.setSaveProcessRequest(saveProcessRequest);

        OapiProcessSaveResponse response = null;
        try {
            response = client.execute(request, AccessTokenUtil.getToken());
        } catch (ApiException e) {
            e.printStackTrace();
        }

        System.out.println(JSON.toJSONString(response));
    }
}
