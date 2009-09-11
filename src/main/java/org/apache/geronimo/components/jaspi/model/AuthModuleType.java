/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1.5-b01-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2008.07.15 at 04:13:34 PM PDT 
//


package org.apache.geronimo.components.jaspi.model;

import org.apache.geronimo.components.jaspi.ClassLoaderLookup;

import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.message.AuthException;
import javax.security.auth.message.MessagePolicy;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Map;


/**
 * <p>Java class for authModuleType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="authModuleType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="className" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="requestPolicy" type="{http://geronimo.apache.org/xml/ns/geronimo-jaspi}messagePolicyType"/>
 *         &lt;element name="responsePolicy" type="{http://geronimo.apache.org/xml/ns/geronimo-jaspi}messagePolicyType"/>
 *         &lt;element name="options" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * @version $Rev: $ $Date: $
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "authModuleType", propOrder = {
    "className",
    "requestPolicy",
    "responsePolicy",
    "options"
})
public class AuthModuleType<T>
    implements Serializable
{

    private final static long serialVersionUID = 12343L;
    @XmlElement(required = true)
    protected String className;
    protected String classLoaderName;
    protected MessagePolicyType requestPolicy;
    protected MessagePolicyType responsePolicy;
    @XmlJavaTypeAdapter(StringMapAdapter.class)
    protected Map<String, String> options;

    /**
     * Gets the value of the className property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClassName() {
        return className;
    }

    /**
     * Sets the value of the className property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClassName(String value) {
        this.className = value;
    }

    /**
     * Gets the value of the requestPolicy property.
     * 
     * @return
     *     possible object is
     *     {@link MessagePolicyType }
     *     
     */
    public MessagePolicyType getRequestPolicy() {
        return requestPolicy;
    }

    /**
     * Sets the value of the requestPolicy property.
     * 
     * @param value
     *     allowed object is
     *     {@link MessagePolicyType }
     *     
     */
    public void setRequestPolicy(MessagePolicyType value) {
        this.requestPolicy = value;
    }

    /**
     * Gets the value of the responsePolicy property.
     * 
     * @return
     *     possible object is
     *     {@link MessagePolicyType }
     *     
     */
    public MessagePolicyType getResponsePolicy() {
        return responsePolicy;
    }

    /**
     * Sets the value of the responsePolicy property.
     * 
     * @param value
     *     allowed object is
     *     {@link MessagePolicyType }
     *     
     */
    public void setResponsePolicy(MessagePolicyType value) {
        this.responsePolicy = value;
    }

    /**
     * Gets the value of the options property.
     * 
     * @return
     *     possible object is
     *     {@link Map<String, String> }
     *     
     */
    public Map<String, String> getOptions() {
        return options;
    }

    /**
     * Sets the value of the options property.
     * 
     * @param value
     *     allowed object is
     *     {@link Map<String, String> }
     *     
     */
    public void setOptions(Map<String, String> value) {
        this.options = value;
    }

    public String getClassLoaderName() {
        return classLoaderName;
    }

    public void setClassLoaderName(String classLoaderName) {
        this.classLoaderName = classLoaderName;
    }

    public T newAuthModule(final ClassLoaderLookup classLoaderLookup, final CallbackHandler callbackHandler) throws AuthException {
        final ClassLoader classLoader = classLoaderLookup.getClassLoader(classLoaderName);
        T authModule;
        try {
            authModule = java.security.AccessController
            .doPrivileged(new PrivilegedExceptionAction<T>() {
                public T run() throws ClassNotFoundException, SecurityException, NoSuchMethodException, IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException, AuthException {
                    Class<? extends T> cl = (Class<? extends T>) Class.forName(className, true, classLoader);
                    Constructor<? extends T> cnst = cl.getConstructor();
                    T authModule = cnst.newInstance();
                    Method m = cl.getMethod("initialize", MessagePolicy.class, MessagePolicy.class, CallbackHandler.class, Map.class);
                    MessagePolicy reqPolicy = requestPolicy == null? null:requestPolicy.newMessagePolicy(classLoader);
                    MessagePolicy respPolicy = responsePolicy == null? null: responsePolicy.newMessagePolicy(classLoader);
                    m.invoke(authModule, reqPolicy, respPolicy, callbackHandler, options);
                    return authModule;
                }
            });
        } catch (PrivilegedActionException e) {
            Exception inner = e.getException();
            if (inner instanceof InstantiationException) {
                throw (AuthException) new AuthException("AuthConfigFactory error:"
                                + inner.getCause().getMessage()).initCause(inner.getCause());
            } else {
                throw (AuthException) new AuthException("AuthConfigFactory error: " + inner).initCause(inner);
            }
        } catch (Exception e) {
            throw (AuthException) new AuthException("AuthConfigFactory error: " + e).initCause(e);
        }



        return authModule;
    }

}
