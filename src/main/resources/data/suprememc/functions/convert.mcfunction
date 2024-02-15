execute unless block ~ ~ ~ minecraft:cave_air run tag @s add NoConvert
execute as @s[tag=!NoConvert] run summon minecraft:cave_spider ~ ~ ~
execute as @s[tag=!NoConvert] run tp @s ~ -200 ~