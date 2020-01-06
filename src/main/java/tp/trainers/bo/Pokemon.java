package tp.trainers.bo;

import tp.pokemonTypes.bo.PokemonType;

public class Pokemon {
    private String pokemonType;
    private String name;
    private String level;
    private int hp;
    private PokemonType type;



    public PokemonType getType() {
        return type;
    }

    public void setType(PokemonType type) {
        this.type = type;
    }
    public String getPokemonType() {
        return pokemonType;
    }

    public void setPokemonType(String pokemonType) {
        this.pokemonType = pokemonType;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getHpPercent(){
        return 100 * this.hp / this.type.getStats().getHp();
    }
}
