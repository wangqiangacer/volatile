package CountDownLatch;

public enum ConuntryEnum {
    ONE(1,"齐"),
    TWO(2,"楚"),
    THREEE(3,"燕"),
    FOUR(4,"魏"),
    FIVE(5,"赵"),
    SIX(6,"韩");

    private Integer getCode;
    private String getContryName;

    public Integer getGetCode() {
        return getCode;
    }

    public void setGetCode(Integer getCode) {
        this.getCode = getCode;
    }

    public String getGetContryName() {
        return getContryName;
    }

    public void setGetContryName(String getContryName) {
        this.getContryName = getContryName;
    }

    ConuntryEnum(Integer getCode, String getContryName) {
        this.getCode = getCode;
        this.getContryName = getContryName;
    }

    public  static ConuntryEnum forEach_ContryName(int index){
        ConuntryEnum[] conuntryEnums = ConuntryEnum.values();
        for (ConuntryEnum conuntryEnum : conuntryEnums) {
            if(index==conuntryEnum.getCode){
                return conuntryEnum;
            }
        }
        return  null;
    }
}
