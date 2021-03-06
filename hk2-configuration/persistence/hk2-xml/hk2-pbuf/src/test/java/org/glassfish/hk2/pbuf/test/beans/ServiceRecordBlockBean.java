/*
 * Copyright (c) 2017, 2018 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0, which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the
 * Eclipse Public License v. 2.0 are satisfied: GNU General Public License,
 * version 2 with the GNU Classpath Exception, which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 */

package org.glassfish.hk2.pbuf.test.beans;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.glassfish.hk2.xml.api.annotations.Hk2XmlPreGenerate;
import org.glassfish.hk2.xml.api.annotations.PluralOf;
import org.jvnet.hk2.annotations.Contract;

/**
 * @author jwells
 *
 */
@Contract
@Hk2XmlPreGenerate
@XmlRootElement(name="service-record-block")
@XmlType(propOrder={
        "sequenceNumber"
        , "serviceRecords"
        , "notSet"
        , "notSetInt" })
public interface ServiceRecordBlockBean {
    @XmlElement
    public long getSequenceNumber();
    public void setSequenceNumber(long seqNum);
    
    @XmlElement(name="serviceRecord")
    @PluralOf("ServiceRecord")
    public List<ServiceRecordBean> getServiceRecords();
    public ServiceRecordBean addServiceRecord(ServiceRecordBean record);
    public ServiceRecordBean removeServiceRecord(ServiceRecordBean record);
    public ServiceRecordBean lookupServiceRecord(String id);
    public void setServiceRecords(List<ServiceRecordBean> records);
    
    @XmlElement(name="notSet")
    public String getNotSet();
    
    @XmlElement
    public int getNotSetInt();

}
