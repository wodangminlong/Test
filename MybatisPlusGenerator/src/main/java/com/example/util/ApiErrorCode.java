package com.example.util;

import lombok.Data;

/**
 * api response message info
 *
 * @author dml
 * @date 2020/06/26
 */
@Data
public class ApiErrorCode {

    /**
     * error code
     */
    private int code;

    /**
     * error msg
     */
    private String msg;

    public ApiErrorCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    /**
     * system level error
     */
    public static final ApiErrorCode SUCCESS = new ApiErrorCode(1, "操作成功");
    public static final ApiErrorCode SYSTEM_ERROR = new ApiErrorCode(5000, "系统错误");
    public static final ApiErrorCode VOID_REQUEST = new ApiErrorCode(4001, "无效请求");
    public static final ApiErrorCode PARAMETER_ERROR = new ApiErrorCode(4002, "参数错误");
    public static final ApiErrorCode REQUESTS_ARE_TOO_FREQUENT = new ApiErrorCode(4003, "请求过于频繁,请稍后再试");
    public static final ApiErrorCode NOT_LOGIN = new ApiErrorCode(1001, "请登录");
    public static final ApiErrorCode SESSION_INVALID = new ApiErrorCode(1002, "session非法");
    public static final ApiErrorCode SESSION_EXPIRE = new ApiErrorCode(1003, "会话已过期,请重新登录");
    public static final ApiErrorCode ACCOUNT_LOGIN_ON_OTHER_DEVICES = new ApiErrorCode(1004, "账号在其它设备登录,如非本人操作,请尽快修改密码");
    public static final ApiErrorCode NO_RELEVANT_RECORDS = new ApiErrorCode(1005, "暂无相关记录！");
    public static final ApiErrorCode CHECK_THE_PHONE_NUMBER_AND_VERIFICATION_CODE = new ApiErrorCode(1006, "请检查手机号和验证码是否输入正确！");
    public static final ApiErrorCode VERIFICATION_CODE_ERROR = new ApiErrorCode(1007, "验证码错误！");
    public static final ApiErrorCode VERIFICATION_CODE_HAS_EXPIRED = new ApiErrorCode(1007, "验证码已过期！");
    public static final ApiErrorCode INCONSISTENT_PASSWORDS = new ApiErrorCode(1008, "两次输入的密码不一致！");
    /**
     * program level error
     */
    public static final ApiErrorCode EXCEEDED_THE_NUMBER_OF_FEDERATIONS_CREATED_OR_JOINED = new ApiErrorCode(4004, "超出创建或加入的联盟数量限制");
    public static final ApiErrorCode CONTENT_AND_PICTURE_MUST_BE_FILLED_IN_ONE = new ApiErrorCode(4005, "内容和图片必须填入其中一项");
    public static final ApiErrorCode GET_EASE_MOB_TOKEN_ERROR  = new ApiErrorCode(4006, "环信token获取异常");
    public static final ApiErrorCode UNION_MOMENTS_NOT_EXIST  = new ApiErrorCode(4007, "联盟圈不存在或已删除");
    public static final ApiErrorCode DOCTOR_NOT_EXIST  = new ApiErrorCode(4008, "医生不存在");
    public static final ApiErrorCode DOCTOR_UNION_NOT_EXIST  = new ApiErrorCode(4009, "联盟信息不存在");
    public static final ApiErrorCode THE_USER_ALREADY_HAS_THE_SAME_INVITATION_RECORD  = new ApiErrorCode(4010, "用户已有相同的邀请记录");
    public static final ApiErrorCode USER_HAS_JOINED_UNION_INFO  = new ApiErrorCode(4011, "用户已加入联盟,不能重复操作");
    public static final ApiErrorCode USER_HAS_ADVANCED_ROLE  = new ApiErrorCode(4012, "用户已有高级角色,不能重复操作");
    public static final ApiErrorCode USER_NOT_BE_SPECIAL_DIRECTOR = new ApiErrorCode(4013, "用户已不是区域主任身份,不能重复操作");
    public static final ApiErrorCode UNION_HAS_UPDATE_UNDER_REVIEW  = new ApiErrorCode(4014, "联盟已有审核中的修改,不能重复操作");
    public static final ApiErrorCode USER_NOT_JOINED_UNION_INFO  = new ApiErrorCode(4015, "用户没有加入当前联盟,操作失败");
    public static final ApiErrorCode USER_HAS_ADVANCED_ROLE_CANNOT_QUIT  = new ApiErrorCode(4016, "用户在当前联盟有高级角色,不能退出");
    public static final ApiErrorCode THE_USER_ALREADY_HAS_THE_SAME_APPLY_RECORD  = new ApiErrorCode(4017, "用户已有相同的申请记录");
    public static final ApiErrorCode USER_NOT_BE_AUTHORITATIVE_EXPERT  = new ApiErrorCode(4018, "用户已不是权威专家身份,不能重复操作");
    public static final ApiErrorCode USER_NOT_BE_LEADER_OR_HEAD_NURSE  = new ApiErrorCode(4019, "您已不是当前联盟的盟主或联盟护士长,无权操作");
    public static final ApiErrorCode USER_NOT_BE_LEADER  = new ApiErrorCode(4020, "您已不是当前联盟的盟主,无权操作");
    public static final ApiErrorCode USER_NOT_BE_HEAD_NURSE  = new ApiErrorCode(4021, "用户已不是联盟护士长身份,不能重复操作");
    public static final ApiErrorCode USER_HAS_FULL_MEMBER_ON_OTHER_UNION  = new ApiErrorCode(4022, "用户已在其他联盟有正式身份,不能重复操作");
    public static final ApiErrorCode USER_HAS_AUDIENCE_MEMBER_ON_OTHER_UNION  = new ApiErrorCode(4023, "用户已在其他联盟有观摩身份,不能重复操作");
    public static final ApiErrorCode NO_FROZEN_AMOUNT_DATA_OF_DOCTOR_CONTRACT_FORM_THAT_NEEDS_TO_BE_RETURNED_BY_MONTH_IS_QUERIED
            = new ApiErrorCode(4024, "没有查询到需要按月返还的医生签约单冻结金额数据");
    public static final ApiErrorCode ACTUAL_SIGNING_DAYS_ARE_CALCULATED_AS_ZERO  = new ApiErrorCode(4025, "实际签约天数计算为0,不能再计算");
    public static final ApiErrorCode QUERY_SIGN  = new ApiErrorCode(4026, "查询签约患者异常");
    public static final ApiErrorCode QUERY_UPDATE_INFO_RECORD = new ApiErrorCode(4027, "查询无更新记录表异常");
    public static final ApiErrorCode ACCOUNT_OR_PWD_ERROR  = new ApiErrorCode(4028, "账号或密码错误");
    public static final ApiErrorCode USER_INFO_ERROR  = new ApiErrorCode(4029, "用户信息异常,请联系管理员");
    public static final ApiErrorCode NUMBER_SOURCE_HAS_BEEN_RESERVED  = new ApiErrorCode(4030, "当前号源已被预约,不能进行删除");
    public static final ApiErrorCode ALI_PAY_AUTH_ERROR  = new ApiErrorCode(4031, "支付宝支付回调[主函数]签名[认证失败]！");
    public static final ApiErrorCode ALI_PAY_MAIN_ERROR  = new ApiErrorCode(4032, "付宝支付回调[主函数][出现异常]！");
    public static final ApiErrorCode ALI_PAY_RECALL_ERROR  = new ApiErrorCode(4033, "支付宝回调没有拿到锁,返回失败!");
    public static final ApiErrorCode ALI_PAY_SEND_CARD_ERROR  = new ApiErrorCode(4034, "发送卡片失败，请检查输入参数!");
    public static final ApiErrorCode ALI_PAY_SEND_ERROR  = new ApiErrorCode(4035, "后台发送卡片失败!");




    /**
     * roster related error
     */
    public static final ApiErrorCode LESS_THAN_RESERVE_SOURCE = new ApiErrorCode(4033, "修改后号源数量小于已预约号源数量");
    public static final ApiErrorCode UPDATE_SCHEDULE_ERROR = new ApiErrorCode(4035, "修改排班操作失败");
    public static final ApiErrorCode ADD_SCHEDULE_ERROR = new ApiErrorCode(4036, "新增排班操作失败");
    public static final ApiErrorCode ROSTER_EXISTED = new ApiErrorCode(4037, "当前排班已存在，请重新设置");
    public static final ApiErrorCode UPDATE_PEOPLE_MORE_THAN_THE_RESERVE_COUNT = new ApiErrorCode(4038, "预约数量不能小于已预约人数，如需修改请先取消预约");
    public static final ApiErrorCode ADD_SCHEDULE_TIME_ERROR = new ApiErrorCode(4039, "当前时间段已存在，请勿重复放号");
    public static final ApiErrorCode ALREADY_RESERVE = new ApiErrorCode(4040, "当前时间段已有预约，如需修改时间请先取消当前预约");
    public static final ApiErrorCode EXCEEDED_QUANTITY_LIMIT = new ApiErrorCode(4041, "超出平均号源数量限制!请重新设置！");
    public static final ApiErrorCode RESELECT_TIME = new ApiErrorCode(4042, "此段时间已安排,请重新选择时间！");
    public static final ApiErrorCode NUMBER_OF_NUMBERS = new ApiErrorCode(4043, "该时间段内的放号数量大于国内平均值,请确认是否保存?");
    public static final ApiErrorCode CHECK_DATE_FAIL = new ApiErrorCode(4044, "该时间段有误，请重新选择时间段");
    public static final ApiErrorCode FORECAST_BROADCAST_TIME = new ApiErrorCode(4045, "[直播预告]预告直播时间不能为空！");
    public static final ApiErrorCode KEYWORD_PARAMETER_MISMATCH = new ApiErrorCode(4046, "[直播详情]关键词参数值不匹配！");
    public static final ApiErrorCode KEYWORD_ORDER_MISMATCH = new ApiErrorCode(4047, "此订单不存在，请检查订单编号!");
    public static final ApiErrorCode KEYWORD_RESERVE_FAILED = new ApiErrorCode(4048, "预约信息查询失败!");

    public static final ApiErrorCode KEYWORD_FILE_COUNT_MISMATCH = new ApiErrorCode(5001, "[文件]图片上传数量超过限制！");
    public static final ApiErrorCode KEYWORD_FILE_MISMATCH = new ApiErrorCode(5002, "[文件]不支持的文件类型！");

    //直播课件
    public static final ApiErrorCode KEYWORD_BROADCAST_PAY_MISMATCH = new ApiErrorCode(2060109, "金额有误,请确定消费的金额是否和订单一致!");
    public static final ApiErrorCode KEYWORD_BROADCAST_REWARD_MISMATCH = new ApiErrorCode(2060104, "超出课件可用积分限制!");
    public static final ApiErrorCode KEYWORD_PHONE_MISMATCH = new ApiErrorCode(2060108, "用户手机号不能为空!");
    public static final ApiErrorCode KEYWORD_OPENID_MISMATCH = new ApiErrorCode(2060106, "未查询到openid！");
    public static final ApiErrorCode KEYWORD_MONEY_MISMATCH = new ApiErrorCode(2060111, "用户余额不足,操作失败！");
    public static final ApiErrorCode KEYWORD_BUY_MISMATCH = new ApiErrorCode(2060107, "用户已购买,请勿重复操作！");
    public static final ApiErrorCode KEYWORD_BROADCAST_END_MISMATCH = new ApiErrorCode(2060105, "未查询到课件或课件已下架！");
    public static final ApiErrorCode KEYWORD_BROADCAST_PAY_TYPE = new ApiErrorCode(2020063, "[支付]请求支付类型错误！");



    public static final ApiErrorCode NON_PERSONAL_OPERATION = new ApiErrorCode(4060, "非本人操作！");
    public static final ApiErrorCode DATA_ALREADY_EXISTS = new ApiErrorCode(4061, "数据已存在！请勿重复操作！");
    public static final ApiErrorCode KEYWORD_MISMATCH = new ApiErrorCode(4062, "[直播详情]关键词参数值不匹配！");
    public static final ApiErrorCode LIVE_IS_NOT_CLOSED = new ApiErrorCode(4063, "当前存在<未关闭>的直播间！请关闭后再重新开播！");
    public static final ApiErrorCode DATA_OBJECT_ABNORMAL = new ApiErrorCode(4063, "[消息]数据对象异常！");
    public static final ApiErrorCode REQUEST_PARAMETER_HAS_NULL_VALUE = new ApiErrorCode(4064, "请求参数存在空值！请检查后重试！");
    public static final ApiErrorCode NUMBER_AVAILABLE_TIMES_EXCEEDED = new ApiErrorCode(4065, "已超出今日可用次数！请明日重试！");
    public static final ApiErrorCode INCORRECT_MOBILE_PHONE_NUMBER_INPUT = new ApiErrorCode(4066, "手机号码输入不正确！");



    public static final ApiErrorCode CHECK_PHONE_AND_VERIFICATION_CODE = new ApiErrorCode(4080, "请检查手机号和验证码是否输入正确！");
    public static final ApiErrorCode QUERY_USER_INFORMATION_FAIL = new ApiErrorCode(4081, "查询新用户信息失败！");
    public static final ApiErrorCode FAILED_TO_CREATE_USER = new ApiErrorCode(4082, "创建用户失败!");
    public static final ApiErrorCode TOKEN_GENERATION_EXCEPTION = new ApiErrorCode(4083, "生成Token出现异常!");
    public static final ApiErrorCode PICTURE_DOES_NOT_EXIST = new ApiErrorCode(4083, "当前用户比对图片不存在!");


    public static final ApiErrorCode NO_DOCTOR_RECORD_FOUND = new ApiErrorCode(4084, "[医患绑定]未查找到医生记录！请检查二维码！");
    public static final ApiErrorCode RELATIONSHIP_IS_BOUND = new ApiErrorCode(4084, "[医患绑定]已处于绑定状态！");


    public static final ApiErrorCode GRAPHIC_TEXT_INSUFFICIENT_APPOINTMENTS = new ApiErrorCode(4091, "剩余图文次数小于1，不能进行预约！");
    public static final ApiErrorCode AUDIO_INSUFFICIENT_APPOINTMENTS = new ApiErrorCode(4092, "剩余音频次数小于1，不能进行预约！");
    public static final ApiErrorCode VIDEO_INSUFFICIENT_APPOINTMENTS = new ApiErrorCode(4093, "剩余视频次数小于1，不能进行预约！");
    public static final ApiErrorCode TELEPHONE_INSUFFICIENT_APPOINTMENTS = new ApiErrorCode(4094, "剩余电话次数小于1，不能进行预约！");
    public static final ApiErrorCode APPOINTMENT_ALREADY_EXISTS = new ApiErrorCode(4095, "预约信息已存在，不能重新预约");
    public static final ApiErrorCode ABNORMAL_DOCTOR_INFORMATION = new ApiErrorCode(4096, "医生信息异常，请联系管理员");
    public static final ApiErrorCode ABNORMAL_PATIENT_INFORMATION = new ApiErrorCode(4097, "患者信息异常，请联系管理员");


    /**
     * ca
     */
    public static final ApiErrorCode ECA_SYSTEM_ERROR = new ApiErrorCode(7000, "医生未进行ca认证");
    public static final ApiErrorCode ECA_SIGN_QUTH_ERROR = new ApiErrorCode(7001, "ca静默签署权限未开启");
    public static final ApiErrorCode ECA_SIGN_FIELDS_ERROR = new ApiErrorCode(7002, "未查询到签署区！");
    public static final ApiErrorCode ECA_SIGN_FIELD_ERROR = new ApiErrorCode(7003, "未查询到签署id！");
    public static final ApiErrorCode ECA_DELETE_SIGN_FIELD_ERROR = new ApiErrorCode(7004, "删除签署信息！");
    public static final ApiErrorCode ECA_CREATE_SIGN_FIELD_ERROR = new ApiErrorCode(7005, "创建签署信息！");
    public static final ApiErrorCode ECA_DOCTOR_INFO_ERROR = new ApiErrorCode(7006, "医生未认证，请先进行医生认证！");
    public static final ApiErrorCode ECA_DOCTOR_IDNUMBER_INFO_ERROR = new ApiErrorCode(7007, "身份证信息为空！");
    public static final ApiErrorCode ECA_CREATE_ACCOUNT_ERROR = new ApiErrorCode(7008, "创建ca账号失败！");
    public static final ApiErrorCode ECA_DOWNLOAD_FILE_ERROR = new ApiErrorCode(7009, "文件下载失败！");
    public static final ApiErrorCode ECA_UPLOAD_FILE_ERROR = new ApiErrorCode(7010, "文件上传失败！");
    public static final ApiErrorCode ECA_UPLOAD_FILE_WAY_ERROR = new ApiErrorCode(7011, "ca上传方式创建文件失败！");
    public static final ApiErrorCode ECA_SIGN_FILE_WAY_ERROR = new ApiErrorCode(7012, "ca一步发起签署失败！");
    public static final ApiErrorCode ECA_SIGN_ADDRESS_WAY_ERROR = new ApiErrorCode(7013, "获取签署地址失败！");
    public static final ApiErrorCode ECA_SIGN_ERROR = new ApiErrorCode(7014, "手绘签名不存在！");
    public static final ApiErrorCode ECA_CREATE_SIGN_ERROR = new ApiErrorCode(7015, "ca创建处方笺印章失败！");
    public static final ApiErrorCode ECA_FLOW_INFO_ERROR = new ApiErrorCode(7016, "ca流程信息不存在！");
    public static final ApiErrorCode ECA_ARCHIVE_SIGN_FLOW_ERROR = new ApiErrorCode(7017, "ca归档失败！");
    public static final ApiErrorCode ECA_ARCHIVE_SIGN_ADDRESS_ERROR = new ApiErrorCode(7018, "获取签署文档地址失败！");


}
