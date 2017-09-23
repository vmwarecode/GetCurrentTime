/*
 * ****************************************************************************
 * Copyright VMware, Inc. 2010-2016.  All Rights Reserved.
 * ****************************************************************************
 *
 * This software is made available for use under the terms of the BSD
 * 3-Clause license:
 *
 * Redistribution and use in source and binary forms, with or without 
 * modification, are permitted provided that the following conditions
 * are met:
 * 1. Redistributions of source code must retain the above copyright 
 *    notice, this list of conditions and the following disclaimer.
 * 
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in 
 *    the documentation and/or other materials provided with the 
 *    distribution.
 * 
 * 3. Neither the name of the copyright holder nor the names of its 
 *    contributors may be used to endorse or promote products derived
 *    from this software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS
 * FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE 
 * COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT,
 * INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING,
 * BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS
 * OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR
 * TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE
 * USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */


package com.vmware.general;

import com.vmware.common.annotations.Action;
import com.vmware.common.annotations.Sample;
import com.vmware.connection.ConnectedVimServiceBase;
import com.vmware.vim25.RuntimeFaultFaultMsg;

import javax.xml.datatype.XMLGregorianCalendar;
import java.text.SimpleDateFormat;

/**
 * <pre>
 * GetCurrentTime
 *
 * This sample gets the current time of the vSphere Server
 *
 * <b>Parameters:</b>
 * url          [required] : url of the web service
 * username     [required] : username for the authentication
 * password     [required] : password for the authentication
 *
 * <b>Command Line:</b>
 * run.bat com.vmware.general.GetCurrentTime
 * --url [webservicesurl] --username [Username] --password [password]
 * </pre>
 */
@Sample(
        name = "get-current-time",
        description = "This sample gets the current time of the vSphere Server"
)
public class GetCurrentTime extends ConnectedVimServiceBase {
    /**
     * This method retrieves the current time from the server and prints it.
     *
     * @throws RuntimeFaultFaultMsg
     */
    @Action
    public void getCurrentTime() throws RuntimeFaultFaultMsg {
        XMLGregorianCalendar ct = vimPort.currentTime(this.getServiceInstanceReference());
        SimpleDateFormat sdf =
                new SimpleDateFormat("yyyy-MM-dd 'T' HH:mm:ss.SSSZ");
        System.out.println("Server current time: "
                + sdf.format(ct.toGregorianCalendar().getTime()));
    }
}