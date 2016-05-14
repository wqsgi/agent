import com.sun.tools.attach.AgentInitializationException;
import com.sun.tools.attach.AgentLoadException;
import com.sun.tools.attach.AttachNotSupportedException;
import com.sun.tools.attach.VirtualMachine;

import java.io.IOException;

/**
 * Created by weiqisong on 2016/5/14.
 */
public class Core {


    public static void main(String[] args) throws IOException, AttachNotSupportedException, AgentLoadException, AgentInitializationException {
        // args[0]为java进程id
//        VirtualMachine virtualMachine = com.sun.tools.attach.VirtualMachine.attach("8528");
//        // args[1]为共享库路径，args[2]为传递给agent的参数
//        virtualMachine.loadAgent("J:\\open-source3\\wei-agent\\agent\\target\\agent-1.0-SNAPSHOT.jar");
//        virtualMachine.detach();
        Test test = new Test();
        test.test111();
    }
}
