package fr.fireowls.harearswarriors.harearsapi.game.card;

public abstract class Card {

    protected CardType type;
    protected String id;

    protected CardMeta meta;


    public CardType getType() {
        return type;
    }

    public void setCardMeta(CardMeta meta) {
        this.meta = meta;
    }

    public CardMeta getCardMeta() {
        return meta;
    }
}
