package net.faleh.postalcode.api;

import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.slf4j.MDC;

public class MdcCleanUpInterceptor extends AbstractPhaseInterceptor<Message> {

	public MdcCleanUpInterceptor() {
		super(Phase.SETUP_ENDING);
	}

	@Override
	public void handleMessage(Message message) throws Fault {
		MDC.clear();

	}
}
