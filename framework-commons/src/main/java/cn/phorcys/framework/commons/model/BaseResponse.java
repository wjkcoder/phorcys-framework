package cn.phorcys.framework.commons.model;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;

/**
 * @Author: Wonder
 * @Date: Created on 2020/5/9 4:33 下午
 */
@Getter
@Setter
public abstract class BaseResponse implements IResult {
//    @XmlElement(name = "ResponseStatus", required = true)
//    protected ResponseStatusType responseStatus;

    @XmlElement(name = "RequestId")
    protected String requestId;

    @XmlElement(name = "Cost")
    protected long cost;

    @XmlElement(name = "Successful")
    protected boolean successful;

    @XmlElement(name = "Message")
    protected String message;

    @XmlElement(name = "errorCode")
    protected String errorCode;
}
