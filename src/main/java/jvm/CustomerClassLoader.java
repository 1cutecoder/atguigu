package jvm;

import java.io.FileNotFoundException;

/**
 * @author zcl
 * @date 2021/9/29 11:09
 */
public class CustomerClassLoader extends ClassLoader {

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            byte[] result = getClassFromCustomerPath(name);
            if (result == null) {
                throw new FileNotFoundException();
            } else {
                return defineClass(name, result, 0, result.length);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static byte[] getClassFromCustomerPath(String name) {
        //���Զ���·���м���ָ����
        //���ָ��·�����ֽ����ļ������˼��ܣ�����Ҫ�ڴ˷����н��н��ܲ���
        return null;
    }
}
