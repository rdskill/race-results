package br.com.rsousa.transformers;

import br.com.rsousa.pojo.Driver;

import java.util.List;

public class DriverTransformer {
    public static Driver toDriver(br.com.rsousa.pojo.ams.Driver amsDriver, int position, String raceTimeFormatted, List<Driver> drivers) {
        Driver driver = new Driver();
        driver.setName(amsDriver.getName());
        driver.setBestLap(amsDriver.getBestLapTime());
        driver.setLaps(amsDriver.getLaps());
        driver.setPosition(position);
        driver.setRaceTimeFormatted(raceTimeFormatted);

        String driverTeamName = drivers.stream().filter(d -> amsDriver.getName().trim().equals(d.getName()))
                .map(d -> d.getTeam())
                .findAny()
                .orElse(amsDriver.getTeamName());

        driver.setTeam(driverTeamName);

        return driver;
    }
}
