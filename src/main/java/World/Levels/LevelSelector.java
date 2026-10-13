package World.Levels;

import Services.LoggingService.ConsoleLogger;
import Services.LoggingService.Enums.ErrorLevelEnum;
import World.Interfaces.ILevel;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class LevelSelector {
    public static ILevel GetLevelByNumber(int levelNumber) {
        return LevelList()
                .stream()
                .filter(level -> level.GetLevelNumber() == levelNumber)
                .findFirst()
                .get();
    }

    public static int GetLevelNumberByCode(String levelCode) {
        if (levelCode == null || levelCode.trim().isEmpty()) {
            return 0;
        }

        return LevelList().stream()
                .filter(level -> level.GetLevelCode() != null &&
                        level.GetLevelCode().equalsIgnoreCase(levelCode.trim()))
                .findFirst()
                .map(ILevel::GetLevelNumber)
                .orElseGet(() -> {
                    ConsoleLogger.LogError(ErrorLevelEnum.WARNING, "Could not get level from code: " + levelCode);
                    return 0;
                });
    }

    private static ArrayList<ILevel> LevelList() {
        return new ArrayList<ILevel>(List.of(
                new LevelOne(),
                new LevelTwo(),
                new LevelThree()
            )
        );
    }
}
