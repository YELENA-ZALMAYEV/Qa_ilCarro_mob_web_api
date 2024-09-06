package dto;

import lombok.*;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class CarDto {

    private  String serialNumber;
    private  String manufacture;
    private  String model;
    private  String year;
    private  String fuel;

    private  int seats;
    private  String carClass;
    private  double pricePerDay;
    private  String about;
    private  String city;
    private  double lat;
    private  double lng;
    private  String image;
    private  String owner;
    private List<BookedDto> bookedPeriods;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarDto carDto = (CarDto) o;
        return seats == carDto.seats && Double.compare(pricePerDay, carDto.pricePerDay) == 0 && Objects.equals(serialNumber, carDto.serialNumber) && Objects.equals(manufacture, carDto.manufacture) && Objects.equals(model, carDto.model) && Objects.equals(year, carDto.year) && Objects.equals(fuel, carDto.fuel) && Objects.equals(carClass, carDto.carClass) && Objects.equals(about, carDto.about) && Objects.equals(city, carDto.city) && Objects.equals(image, carDto.image) && Objects.equals(owner, carDto.owner) && Objects.equals(bookedPeriods, carDto.bookedPeriods);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serialNumber, manufacture, model, year, fuel, seats, carClass, pricePerDay, about, city, image, owner, bookedPeriods);
    }

    //    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        CarDto carDto = (CarDto) o;
//        return seats == carDto.seats && Double.compare(pricePerDay, carDto.pricePerDay) == 0 && Double.compare(lat, carDto.lat) == 0 && Double.compare(lng, carDto.lng) == 0 && Objects.equals(serialNumber, carDto.serialNumber) && Objects.equals(manufacture, carDto.manufacture) && Objects.equals(model, carDto.model) && Objects.equals(year, carDto.year) && Objects.equals(fuel, carDto.fuel) && Objects.equals(carClass, carDto.carClass) && Objects.equals(about, carDto.about) && Objects.equals(city, carDto.city) && Objects.equals(image, carDto.image) && Objects.equals(owner, carDto.owner) && Objects.equals(bookedPeriods, carDto.bookedPeriods);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(serialNumber, manufacture, model, year, fuel, seats, carClass, pricePerDay, about, city, lat, lng, image, owner, bookedPeriods);
//    }
}
