# Copilot Instructions for click-mining-forever

## Project Overview
This is a **Babric** (legacy Fabric) mod for **Minecraft Beta 1.7.3** using Java 8. Babric is a fork of Fabric Loader designed for pre-release Minecraft versions.

**Mod Purpose**: Restores "click mining" behavior from pre-Beta 1.3. In early Minecraft, rapidly clicking after breaking a block allowed faster mining by skipping the delay. Jeb fixed this by moving the delay from after to before block breaking. This mod removes/nullifies that pre-mining delay using mixins.

## Critical Build Context
- **Loom variant**: `babric-loom` (not standard Fabric Loom)
- **Minecraft version**: Beta 1.7.3 (`b1.7.3`)
- **Mappings**: Barn mappings (`babric:barn`) from Babric, not Yarn
- **Java compatibility**: Target Java 8 (`sourceCompatibility = targetCompatibility = JavaVersion.VERSION_1_8`)
- **Build command**: `./gradlew build` (use `gradlew.bat` on Windows)
- **Run configurations**: Use the Gradle tasks `runClient` or `runServer` provided by babric-loom

## Repository-Specific Patterns

### Maven Repositories
All Babric dependencies come from `https://maven.glass-launcher.net/babric` - this is configured in both `build.gradle` and `settings.gradle`. Standard Fabric dependencies won't work.

### Intermediary Mappings
Uses custom intermediary URL: `https://maven.glass-launcher.net/babric/babric/intermediary/%1$s/intermediary-%1$s-v2.jar`

### Manifest Polyfill
Beta 1.7.3 requires a custom manifest: `https://babric.github.io/manifest-polyfill/b1.7.3.json`

## Implementation Strategy
The mod works by targeting the mining delay mechanism in Beta 1.7.3:
- **Target class**: Look for player/mining controller classes that handle block breaking
- **Delay field**: Find the field that stores the mining cooldown timer
- **Mixin approach**: Either nullify the delay before it's checked, or prevent it from being set
- **Beta 1.7.3 specific**: Class names differ from modern Minecraft - use Barn mappings to identify correct targets

## Mixin Configuration
- Mixins JSON: `src/main/resources/modid.mixins.json`
- Compatibility level: `JAVA_8` (not higher)
- Client mixins go in `"client": []` array
- Server/common mixins go in `"mixins": []` array
- Example shows title screen injection pattern

## Version Information
Check `gradle.properties` for:
- Loader version: `0.15.6-babric.2`
- Mappings: `b1.7.3+build.8`
- Mod version: `1.0.0`

## Important Limitations
- Beta 1.7.3 has different class names and APIs than modern Minecraft
- Many modern Fabric API features don't exist in Babric
- Consult Babric documentation: https://babric.github.io/develop/

## Workflow Notes
- CI builds on Java 17 despite Java 8 bytecode target
- Artifacts generated in `build/libs/`
- License is CC0-1.0 (public domain equivalent)
