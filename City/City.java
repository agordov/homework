package homework.City;

public class City {
    public static void main(String[] args) {
        ApartmentHouse obschsaga = new ApartmentHouse("Pervomayskaya", 30, 4, 144);
        obschsaga.setInhabInFlat(1, 4);
        System.out.println(obschsaga.getStreet());
    }
}
