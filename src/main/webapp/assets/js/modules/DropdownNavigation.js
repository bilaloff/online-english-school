export default class DropdownNavigation {
    constructor(menu, button) {
        this.menu = menu
        this.button = button
        this.events()
    }

    events() {
        this.button.addEventListener('click', this.toggleDropdown.bind(this))
    }

    toggleDropdown(e) {
        e.preventDefault()
        e.stopPropagation()
        if (this.menu.classList.contains('show')) {
            this.hideDropdown()
        } else {
            document.addEventListener('click', this.hideDropdown.bind(this), {once: true})
            this.menu.classList.add('show')
        }
    }

    hideDropdown() {
        this.menu.classList.remove('show')
    }
}
