package designpattern.builder.extension;

/**
 * @author zcl
 * @date 2021/12/9 13:51
 */
public class Phone {
    private String cpu;
    private String screen;
    private String memory;
    private String mainboard;

    public Phone(Builder builder) {
        this.cpu = builder.cpu;
        this.screen = builder.screen;
        this.memory = builder.memory;
        this.mainboard = builder.mainboard;

    }

    public static final class Builder {
        private String cpu;
        private String screen;
        private String memory;
        private String mainboard;

        public Builder cpu(String cpu) {
            this.cpu = cpu;
            return this;
        }

        public Builder screen(String screen) {
            this.screen = screen;
            return this;
        }

        public Builder memory(String memory) {
            this.memory = memory;
            return this;
        }

        public Builder mainboard(String mainboard) {
            this.mainboard = mainboard;
            return this;
        }

        public Phone build(){
            return new Phone(this);
        }
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Phone{");
        sb.append("cpu='").append(cpu).append('\'');
        sb.append(", screen='").append(screen).append('\'');
        sb.append(", memory='").append(memory).append('\'');
        sb.append(", mainboard='").append(mainboard).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
