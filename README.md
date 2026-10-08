# Depth-Danger

## Projektidé

Projektet är tänkt att efterlikna en simpel Dungeon Crawler där man spelar en karaktär som slåss mot monster, samlar guld och ska gå djupare ner i nivåer.

## Superklass

- Namn: Entity
- Gemensamma fält: Max och Current HP är några fält som kan vara gemensamma för alla subklasser.
- Gemensamma metoder: Metoder för att flytta en entitet är något som kan vara gemensamma för alla subklasser.

## Subklasser (minst tre)

1. Character — Det är spelarens karaktär och därav kan den även samla guld och gå upp i levels.
2. BasMonster — Basmonster kommer att ha en simpel logik för hur de rör på sig.
3. Humanoid och Undead — De har olika egenskaper för att slåss och patrullera

## Interface

- Namn: ILevel
- Metod(er): Har metoder där nivån lever, hur stor den är samt dess monster.
- Implementeras av (minst två subklasser): LevelOne och LevelTwo är två olika nivåer som använder sig av ILevel som är en konkret implementering av ILevel.

## Meny

Då det är ett spel så är fokus mer på att man ska kunna interagera med spelet och att man ska kunna slåss mot monster än en ren CRUD-funktion.

## Felscenarion

Minst två konkreta situationer i just ert program som kan gå fel och som ni behöver hantera (inte generella exempel).

## Motivering (fylls i senare i veckan)

När ni kommit igång och gjort några ändringar: skriv kort varför strukturen ser ut som den gör, och om ni övervägde ett annat sätt att lösa det på. Detta behöver inte fyllas i redan i första commiten.