class MyRegex {

    public static void main(String[] args) {
        String ipNum = "(\\d{1,2}|(0|1)\\d{2}|2[0-4]\\d|25[0-5])";
        String pattern = ipNum + "." + ipNum + "." + ipNum + "." + ipNum;

        String IP = "1.255.04.199";

        System.out.println(IP.matches(pattern));
    }
}