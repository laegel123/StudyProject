package com.example.effectivejava.item03;

import org.junit.jupiter.api.Test;

import java.io.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SingletonObjectWithSerializableTest {
    @Test
    void equals() throws IOException, ClassNotFoundException {
        MemberWithSerializable member1 = MemberWithSerializable.getInstance();
        String fileName = "object.obj";

        // 직렬화
        ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)));
        out.writeObject(member1);
        out.close();

        // 역직렬화
        ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fileName)));
        MemberWithSerializable member2 = (MemberWithSerializable) in.readObject();
        in.close();

        assertThat(member1).isEqualTo(member2);
    }
}
