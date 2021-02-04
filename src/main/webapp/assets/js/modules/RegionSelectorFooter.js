export default class RegionSelectorFooter {
    constructor(select) {
        this.select = select
        this.events()
    }

    events() {
        this.select.addEventListener('change', this.selectionHandler.bind(this));
    }

    selectionHandler() {
        let selectedIndex = this.select.selectedIndex
        let selectedItem = this.select.item(selectedIndex);
        let selectedRegion = selectedItem.value
        let locale = '?locale='.concat(selectedRegion)
        location.assign(location.origin.concat(location.pathname).concat(locale));
    }
}
