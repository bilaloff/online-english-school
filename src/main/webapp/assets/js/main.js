import RegionSelectorFooter from './modules/RegionSelectorFooter.js'
import DropdownNavigation from "./modules/DropdownNavigation.js"

const regionSelector = document.querySelector('#select-region')

if(regionSelector){
    new RegionSelectorFooter(regionSelector)
}

const dropdownButton = document.getElementById('dropdown-button')
const dropdownMenu = document.getElementById('dropdown-menu')

if (dropdownMenu && dropdownButton) {
    new DropdownNavigation(dropdownMenu, dropdownButton)
}
